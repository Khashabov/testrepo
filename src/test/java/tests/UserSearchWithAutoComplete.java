package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductPage;
import pages.SearchPage;

public class UserSearchWithAutoComplete extends TestBase {

	
	String ProductName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObj ; 
	ProductPage productObj;
	
	@Test
	public void autoCompleteSearch() throws InterruptedException
	{
		
		searchObj = new SearchPage(driver);
		productObj = new ProductPage(driver);
		searchObj.searchAithAutoComplete("Macb");
		Thread.sleep(3000);
		Assert.assertTrue(productObj.currentItem.getText().contains("Apple MacBook"));
		Thread.sleep(3000);
		
	}
	
	
}
