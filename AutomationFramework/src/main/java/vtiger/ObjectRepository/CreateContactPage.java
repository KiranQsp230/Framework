package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	// Constructor
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnameTextFieldEdt;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement organizationCreateIcon;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButtonInCreateContactPage;

	public WebElement getLastnameTextFieldEdt() {
		return lastnameTextFieldEdt;
	}

	public WebElement getOrganizationCreateIcon() {
		return organizationCreateIcon;
	}

	public WebElement getSaveButtonInCreateContactPage() {
		return saveButtonInCreateContactPage;
	}

}
