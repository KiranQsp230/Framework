package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class DemoScriptWithTestNgTest {

	@Test
	public void toCreateContactTest() throws Exception {

		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		String URL = putil.toReadDataFromProperty("url");
		String BROWSER = putil.toReadDataFromProperty("browser");
		System.out.println(BROWSER);
		String USERNAME = putil.toReadDataFromProperty("username");
		System.out.println(USERNAME);
		String PASSWORD = putil.toReadDataFromProperty("password");

		String contactName = eutil.toReadDataFromExcel("Contacts", 1, 2);

		// To launch browser
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		driver.get(URL);

		// To login
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextFieldEdt().sendKeys(USERNAME);
		lp.getPasswordTextfieldEdt().sendKeys(PASSWORD);
		lp.getLoginButton().click();

		// To click on Contacts link
		HomePage wp = new HomePage(driver);
		wp.getContactsLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactIcon().click();

		// To fill details
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextFieldEdt().sendKeys(contactName);
		ccp.getSaveButtonInCreateContactPage().click();

		// To verify
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if (name.contains(contactName)) {
//			System.out.println(name + "--Passed--");
//		} else {
//			System.out.println("--Failed--");
//		}
		Assert.assertTrue(name.contains(contactName));
		Reporter.log("Contact Created Successfully", true);

		// To logout
		wutil.toMouseHover(driver, wp.getLogoutButton());
		wp.getSignOutLink().click();

		// To close
		driver.quit();

	}
}