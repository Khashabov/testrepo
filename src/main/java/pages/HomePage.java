package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver);
	}
	
	@FindBy(linkText = "Register")
	WebElement RegisterLink;
	
	@FindBy(css = "a.ico-login")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement ContactUseBtn; 
	
	@FindBy (linkText = "Computers")
	WebElement computerMenu; 
	
	@FindBy (linkText = "Notebooks")
	WebElement NotebookMenu;
	
	
	public void openRegistrationPage() 
	{
		clickBtn(RegisterLink);
	}
	
	public void openLoginPage()
	{
		clickBtn(loginLink);
	}
	public void openContactUs()
	{
		ScrollDown();
		clickBtn(ContactUseBtn);
	}
	
	public void usrCanHover()
	{
		action.moveToElement(computerMenu).moveToElement(NotebookMenu)
		.click().build().perform();
	}
	
		
	}


