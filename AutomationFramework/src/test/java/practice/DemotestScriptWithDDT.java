package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemotestScriptWithDDT {

	public static void main(String[] args) throws IOException {
		// To read data from property file
		FileInputStream propfis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(propfis);
		String url = prop.getProperty("url");
		String browser = prop.getProperty("browser");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		//To read data from excel
		FileInputStream excelfis = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook workbook = WorkbookFactory.create(excelfis);
		String value = workbook.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();

		
		// To launch browser
		WebDriver driver =null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

		// To perform login
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// To click on contacts
		driver.findElement(By.linkText("Contacts")).click();

		// To click on contacts look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// To enter the data
		driver.findElement(By.name("lastname")).sendKeys(value);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// To verify
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(value)) {
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
