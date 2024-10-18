package testNg;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class ToCreateContactWithOrganizationTest extends BaseClass {

	@Test
	public void createContactWithOrganizationTest() throws EncryptedDocumentException, IOException {

		// To click on contacts link
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		// To click on create contact lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactIcon().click();

		// To create contact with details
		ExcelFileUtility eutil = new ExcelFileUtility();
		String contactName = eutil.toReadDataFromExcel("Contacts", 1, 2);
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextFieldEdt().sendKeys(contactName);
		ccp.getOrganizationCreateIcon().click();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toSwitchToWindow(driver, "Accounts");
		driver.findElement(By.xpath("//a[text()='wipro']")).click();
		wutil.toSwitchToWindow(driver, "Contacts");
		ccp.getSaveButtonInCreateContactPage().click();

		// To verify
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgname = oip.getOrganizationVerification().getText();
		Assert.assertTrue(orgname.contains(contactName), "Failed to create Contact");
		Reporter.log("Successfully created contact", true);
	}
}
