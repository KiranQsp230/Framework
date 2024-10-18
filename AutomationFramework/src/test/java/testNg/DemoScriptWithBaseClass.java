package testNg;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;

public class DemoScriptWithBaseClass extends BaseClass {

	@Test
	public void toCreateContactTest() throws EncryptedDocumentException, IOException {
		// To click on Contacts link
		
		HomePage wp = new HomePage(driver);
		wp.getContactsLink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactIcon().click();

		// To fill details
		ExcelFileUtility eutil = new ExcelFileUtility();
		String contactName = eutil.toReadDataFromExcel("Contacts", 1, 2);
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextFieldEdt().sendKeys(contactName);
		ccp.getSaveButtonInCreateContactPage().click();

		// To verify
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(name.contains(contactName));
		Reporter.log("Contact Created Successfully", true);

	}

}
