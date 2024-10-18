package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class DemoTestScriptWithDDTandGU {

	public static void main(String[] args) throws Exception {

		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);

		// To perform login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// To click on contacts
		driver.findElement(By.linkText("Contacts")).click();

		// To click on contacts look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// To enter the data
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// To verify
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(contactName)) {
			System.out.println(name + "--Passed--");
		} else {
			System.out.println("--Failed--");
		}

		// To logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// To close
		driver.quit();

	}

}
