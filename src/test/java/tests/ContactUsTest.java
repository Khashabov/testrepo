package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {


	ContactUsPage contactPage;
	HomePage home ; 

	@Test 
	public void UserUseContactUs() throws InterruptedException 
	{

		home = new HomePage(driver);
		home.openContactUs();
		contactPage = new ContactUsPage(driver);
		Thread.sleep(1500);
		contactPage.ContactUs("omar", "omar@test.com", "Test Test Test Test ");
		
		Assert.assertTrue(contactPage.SuccessMsg.getText().contains(" has been successfully"));

	}
}
