package testNg;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.ObjectRepository.ContactsInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.HomePage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {

	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException {

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
		ccp.getSaveButtonInCreateContactPage().click();
		Assert.fail();

		// To verify
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		String name = cip.getContactsVerification().getText();
		Assert.assertTrue(name.contains(contactName), "Failed to create contact");
		Reporter.log("Successfully created contact", true);
	}
}
