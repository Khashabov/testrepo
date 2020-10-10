package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css = "strong.current-item")
	public WebElement currentItem ;
	
	@FindBy (xpath  = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div/div/div/div[2]/h2/a")
	WebElement searchRes;
	
	
	public void  chooseAProduct() {
		clickBtn(searchRes);
		
	}

}
