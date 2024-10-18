package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class ToTakesScreenshotPractice {

	public static void main(String[] args) throws Exception {

		WebDriverUtility wutil = new WebDriverUtility();
		PropertyFileUtility putil = new PropertyFileUtility();

		WebDriver driver = new ChromeDriver();
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);

		String url = putil.toReadDataFromProperty("url");
		String username = putil.toReadDataFromProperty("username");
		String password = putil.toReadDataFromProperty("password");

		// To login
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		wutil.toTakeScreenshot(driver, "vtiger");

	}

}
