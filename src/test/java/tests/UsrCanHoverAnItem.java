package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class UsrCanHoverAnItem extends TestBase {

	HomePage homeObj; 
	
	@Test
	public void usrCanHover()
	{
		homeObj = new HomePage(driver);
		homeObj.usrCanHover();
		assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
