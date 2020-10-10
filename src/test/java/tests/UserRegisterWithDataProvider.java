package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class UserRegisterWithDataProvider extends TestBase{


	HomePage homeObject;
	RegistrationPage registerObject; 
	LoginPage loginObject;



	@DataProvider (name = "testData")
	public static Object[][] usrData()
	{
		return new Object[][]
				{
			{"omar","hhh","test2223@test.com","123456"},
			{"ahmed","hhh","test123@test.com","12345678"}
				};

	}

	@Test (priority = 0 , alwaysRun = true, dataProvider = "testData")
	public void UserRegisterSuccesfully(String fname ,String lName ,String email, String password) throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new RegistrationPage(driver);
		loginObject = new LoginPage(driver);
		Thread.sleep(2000);
		registerObject.registrationPage(fname ,lName, email , password);
		Thread.sleep(2000);
		registerObject.logout();
		Thread.sleep(2000);
		homeObject.openLoginPage();
		loginObject.loginPage(email, password);
		Assert.assertTrue(registerObject.logOut.isDisplayed());
		registerObject.logout();
	}


}


