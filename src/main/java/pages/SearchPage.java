package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy (id = "small-searchterms")
	WebElement searchBox;
	
	@FindBy (css = "input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy (id = "ui-id-1")
	List<WebElement> searchResult ;
	
	public void searchItem (String productName)
	{
		setTxt(searchBox, productName);
		clickBtn(searchBtn);
	}
	
	public void searchAithAutoComplete(String searchTxt)
	{
		setTxt(searchBox, searchTxt);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		searchResult.get(0).click();
	}

}
