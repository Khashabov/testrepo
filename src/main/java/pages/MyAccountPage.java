package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (linkText = "Change password")
	WebElement ChangePassLink;

	@FindBy (id = "OldPassword")
	WebElement OldPassword;

	@FindBy (id = "NewPassword")
	WebElement NewPassword ;

	@FindBy (id = "ConfirmNewPassword")
	WebElement ConfirmNewPassword ;

	@FindBy (css  = "input.button-1.change-password-button")
	WebElement SubmitChangePass ;
	
	@FindBy (css = "div.result")
	public WebElement changePassSuccessMsg; 



	public void ChangePassLink()
	{
		clickBtn(ChangePassLink);
	}

	public void ChangePass(String OldPass , String NewPass)
	{
		setTxt(OldPassword , OldPass);
		setTxt(NewPassword, NewPass);
		setTxt(ConfirmNewPassword, NewPass);
		clickBtn(SubmitChangePass);
	}
}





