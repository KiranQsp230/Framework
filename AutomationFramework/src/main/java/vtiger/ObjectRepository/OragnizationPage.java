package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OragnizationPage {

	public OragnizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationIcon;

	public WebElement getCreateOrganizationIcon() {
		return createOrganizationIcon;
	}
}
