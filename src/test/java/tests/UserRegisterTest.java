package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class UserRegisterTest extends TestBase{
 
	
	HomePage homeObject;
	RegistrationPage registerObject; 
	LoginPage loginObject;
	String firstName = "m11";
	String LastName = "ahmed";
	String Mail = "m12st.com";
	String oldPassword = "12345678";
	String NewPassword = "123456";
	
	
	@Test (priority = 0 , alwaysRun = true)
	public void UserRegisterSuccesfully() throws InterruptedException {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver);
		Thread.sleep(2000);
		registerObject.registrationPage(firstName, LastName, Mail, oldPassword);
			Thread.sleep(20);	
		
		Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
	}
	
	@Test  (dependsOnMethods =("UserRegisterSuccesfully"))
	public void registredUserCanLogout() throws InterruptedException
	{
		registerObject.logout();
		Thread.sleep(2000);
	}
	 
	@Test  (dependsOnMethods = ("registredUserCanLogout"))
	public void login() throws InterruptedException 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(6000);
		loginObject.loginPage(Mail,oldPassword);
		Assert.assertTrue(registerObject.logOut.isDisplayed());
		
	}
}


