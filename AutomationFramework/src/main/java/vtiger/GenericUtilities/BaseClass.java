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

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {

	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite
	public void basicConfiguration() {
		Reporter.log("---DataBase connection Successfull---", true);
	}

	@BeforeClass
	public void beforeClassConfiguration() throws Exception {
		String URL = putil.toReadDataFromProperty("url");
		String BROWSER = putil.toReadDataFromProperty("browser");
		// To launch browser
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver;
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		driver.get(URL);
	}

	@BeforeMethod
	public void beforeMethodConfiguration() throws Exception {
		String USERNAME = putil.toReadDataFromProperty("username");
		String PASSWORD = putil.toReadDataFromProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextFieldEdt().sendKeys(USERNAME);
		lp.getPasswordTextfieldEdt().sendKeys(PASSWORD);
		lp.getLoginButton().click();
	}

	@AfterMethod
	public void afterMethodConfiguration() {
		HomePage wp = new HomePage(driver);
		wutil.toMouseHover(driver, wp.getLogoutButton());
		wp.getSignOutLink().click();
		System.out.println("Logged Out");
	}

	@AfterClass
	public void afterClassConfiguration() {
		driver.quit();
	}

}
