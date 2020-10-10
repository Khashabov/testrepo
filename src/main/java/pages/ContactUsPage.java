package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy ( id = "FullName")
	WebElement FullName; 
	
	@FindBy (id = "Email")
	WebElement UsrEmail;
	
	@FindBy (id = "Enquiry")
	WebElement EnquiryTxt;
	
	@FindBy (css = "input.button-1.contact-us-button")
	WebElement SubmitBtn; 
	
	@FindBy (css = "div.result")
	public WebElement SuccessMsg; 
	
	
	public void ContactUs(String Name , String Email , String Enquiry )
	{
		
		setTxt(FullName, Name);
		setTxt(UsrEmail, Email);
		setTxt(EnquiryTxt, Enquiry);
		clickBtn(SubmitBtn);
	}
}
