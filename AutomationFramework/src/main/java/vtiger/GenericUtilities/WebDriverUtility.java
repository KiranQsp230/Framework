package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of generic methods related to webdriver
 * 
 * @author kiran
 *
 */
public class WebDriverUtility {
	/**
	 * This method will maximize the browser
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the browser
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to give implicit
	 * 
	 * @param driver
	 */
	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method will wait until element is visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait until element is clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeClicable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will select element in dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method will select element in dropdown using value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method will select element in dropdown using visibletext
	 * 
	 * @param visibletext
	 * @param element
	 */
	public void toHandleDropdown(String visibletext, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}

	/**
	 * This method will move my cursor to element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method will perform right click on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform Drag and drop
	 * 
	 * @param driver
	 * @param src
	 * @param tar
	 */
	public void toPerformDragAndDrop(WebDriver driver, WebElement src, WebElement tar) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, tar).perform();
	}

	/**
	 * This method is used to switch to alert
	 * 
	 * @param driver
	 */
	public void toSwitchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	/**
	 * This method is used to capture the text present in Alert
	 * 
	 * @param driver
	 * @return
	 */
	public String toSwitchToAlertAndGetText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String textInPopup = alert.getText();
		return textInPopup;
	}

	/**
	 * This method is used click on accept in alert popup
	 * 
	 * @param driver
	 */
	public void toSwitchToAlertAndAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	/**
	 * This method is used click on dismiss in alert popup
	 * 
	 * @param driver
	 */
	public void toSwitchToAlertAndDismiss(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	/**
	 * This method is to switch into frame using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toSwitchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is to switch into frame using String id or name
	 * 
	 * @param driver
	 * @param id_name
	 */
	public void toSwitchToFrame(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);
	}

	/**
	 * This method is switch into frame using Webelement
	 * 
	 * @param driver
	 * @param ele
	 */
	public void toSwitchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	/**
	 * This method is to switch back to parent frame
	 * 
	 * @param driver
	 */
	public void toSwitchBackToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is to switch back to main webpage
	 * 
	 * @param driver
	 */
	public void toSwitchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to switch driver control to window
	 * @param driver
	 * @param partialWebpageText
	 */
	public void toSwitchToWindow(WebDriver driver, String partialWebpageText) {
		// Step 1 :- Capture all windowId
		Set<String> windowIds = driver.getWindowHandles();
		// Step 2 :- Navigate to each window
		for (String win : windowIds) {
			String windowTitle = driver.switchTo().window(win).getTitle();
			if (windowTitle.contains(partialWebpageText)) {
				break;
			}
		}
	}
	/**
	 * This method is used to take a screenshot of entire webpage
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String toTakeScreenshot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File("./errorShots/"+screenshotName+".png");
		org.openqa.selenium.io.FileHandler.copy(temp, src);
		return src.getAbsolutePath(); // used for extent reports
	}
	
	
	
	
	
	
}
	
	
	
	
	
	

