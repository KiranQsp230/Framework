package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToRunYoutube {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.youtube.com/");
		driver.findElement(By.name("search_query")).sendKeys("Eminem houdini");
		driver.findElement(By.id("search-icon-legacy")).click();
		driver.findElement(By.xpath("(//yt-formatted-string[text()='Eminem - Houdini [Official Music Video]'])[1]")).click();
	}

}
