package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	// Constructor
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organizationTextfieldEdt;

	@FindBy(name = "industry")
	private WebElement industryDropDown;

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButtonInCreateOrganizationPage;

	public WebElement getOrganizationTextfieldEdt() {
		return organizationTextfieldEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveButtonInCreateOrganizationPage() {
		return saveButtonInCreateOrganizationPage;
	}
}
