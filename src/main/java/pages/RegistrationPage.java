package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase
{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (id = "gender-male")
	WebElement gender ;

	@FindBy(id = "FirstName")
	WebElement fNametxtbox ; 

	@FindBy (id = "LastName")
	WebElement lNametxtbox;

	@FindBy (id = "Email")
	WebElement emailtxtbox; 

	@FindBy (id = "Password")
	WebElement passwordTxtBox; 

	@FindBy (id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox; 

	@FindBy (id = "register-button")
	WebElement registerBtn; 

	@FindBy (css = "div.result")
	public WebElement successMsg;

	@FindBy (linkText ="Log out")
	public WebElement logOut;

	@FindBy (linkText = "My account")
	WebElement MyAccountBtn; 

	public void registrationPage (String FirstName , String LastName , String email, String password) {

		clickBtn(gender);
		setTxt(fNametxtbox, FirstName);
		setTxt(lNametxtbox, LastName);
		setTxt(emailtxtbox, email);
		setTxt(passwordTxtBox, password);
		setTxt(confirmPasswordTxtBox, password);
		clickBtn(registerBtn);
	}
	public void logout() {		
		clickBtn(logOut);
	}

	public void openMyAccount()
	{
		clickBtn(MyAccountBtn);
	}


}
