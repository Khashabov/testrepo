package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class UserRegisterWithFakerData extends TestBase{


	HomePage homeObject;
	RegistrationPage registerObject; 
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.funnyName().name();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8);

	@Test (priority = 0 , alwaysRun = true)
	public void UserRegisterSuccesfully() throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver);
		Thread.sleep(2000);
		registerObject.registrationPage(firstname, lastname, email, password);
		System.out.println(firstname + " "+lastname+"  "+email+"  "+password);
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
		loginObject.loginPage(email,password);
		Assert.assertTrue(registerObject.logOut.isDisplayed());

	}
}


