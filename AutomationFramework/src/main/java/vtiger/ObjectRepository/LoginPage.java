package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="user_name")
	private WebElement usernameTextFieldEdt;
	
	@FindBy(name= "user_password")
	private WebElement passwordTextfieldEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	@FindBy(xpath ="//img[@alt='logo']")
	private WebElement vtigerImage;

	public WebElement getUsernameTextFieldEdt() {
		return usernameTextFieldEdt;
	}

	public WebElement getPasswordTextfieldEdt() {
		return passwordTextfieldEdt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getVtigerImage() {
		return vtigerImage;
	}
	
	
	
	
	
	
	
}
