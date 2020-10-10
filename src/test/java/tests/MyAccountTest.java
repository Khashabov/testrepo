package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

public class MyAccountTest extends TestBase{

	HomePage homeObject;
	RegistrationPage registerObject; 
	MyAccountPage MyaccountObj ;
	LoginPage loginObject;

	String firstName = "ahmed";
	String lastname = "khaled";
	String OldPass = "12345678";
	String NewPass = "123456";
	String Mail = "m12@test.com";

	@Test
	public void UserRegisterSuccesfully() throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver);
		Thread.sleep(4000);
		registerObject.registrationPage(firstName,lastname,Mail, OldPass);
		Thread.sleep(2000);	

		Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods = "UserRegisterSuccesfully")
	public void UserChangePassword() throws InterruptedException 
	{
		MyaccountObj = new MyAccountPage(driver);
		registerObject.openMyAccount();
		MyaccountObj.ChangePassLink();
		Thread.sleep(3000);
		MyaccountObj.ChangePass(OldPass, NewPass);
		Thread.sleep(3000);
		Assert.assertTrue(MyaccountObj.changePassSuccessMsg.getText().
				contains("Password was changed"));
	}

	@Test  (dependsOnMethods =("UserChangePassword"))
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
		loginObject.loginPage(Mail, NewPass);
		Assert.assertTrue(registerObject.logOut.isDisplayed());

	}

}
