package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClassForGroup {

	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver; // listeners

	@BeforeSuite(groups = { "SmokeSuite", "RegressionSuite" })
	public void basicConfiguration() {
		Reporter.log("---DataBase connection Successfull---", true);
	}

	 @Parameters("browser")
	 @BeforeTest
	//@BeforeClass(groups = { "SmokeSuite", "RegressionSuite" })
	public void beforeClassConfiguration(@Optional("chrome")String BROWSER ) throws Exception {
		String URL = putil.toReadDataFromProperty("url");
		//String BROWSER = putil.toReadDataFromProperty("browser");
		// To launch browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver; // listeners
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		driver.get(URL);
	}

	@BeforeMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void beforeMethodConfiguration() throws Exception {
		String USERNAME = putil.toReadDataFromProperty("username");
		String PASSWORD = putil.toReadDataFromProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextFieldEdt().sendKeys(USERNAME);
		lp.getPasswordTextfieldEdt().sendKeys(PASSWORD);
		lp.getLoginButton().click();
	}

	@AfterMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void afterMethodConfiguration() {
		HomePage wp = new HomePage(driver);
		wutil.toMouseHover(driver, wp.getLogoutButton());
		wp.getSignOutLink().click();
		System.out.println("Logged Out");
	}

	@AfterClass(groups = { "SmokeSuite", "RegressionSuite" })
	public void afterClassConfiguration() {
		driver.quit();
	}
}
