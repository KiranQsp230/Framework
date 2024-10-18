package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemotestScript {

	public static void main(String[] args) {

		//To launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");
		
		//To perform login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//To click on contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//To click on contacts look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//To enter the data
		driver.findElement(By.name("lastname")).sendKeys("Kiran ks");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//To verify
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(name.contains("Kiran ks")) {
			System.out.println(name+"--Passed--");
		}else {
			System.out.println("--Failed--");
		}
		
		//To logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//To close
		driver.quit();
		
	}

}
