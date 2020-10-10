package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductPage;
import pages.SearchPage;

public class SearchItemTest extends TestBase{

	String ProductName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObj ; 
	ProductPage productObj;

	@Test
	public void UserCanSearch() throws InterruptedException 

	{
		searchObj = new SearchPage(driver);
		productObj = new ProductPage(driver);
		searchObj.searchItem(ProductName);
		Thread.sleep(3000);
		productObj.chooseAProduct();


		Assert.assertTrue(productObj.currentItem.getText().contains("Apple MacBook"));

	}


}
