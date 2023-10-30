package automation.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class cartPage {
	
	WebDriver driver;
	public cartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	
	@FindBy(css="[class='cartSection'] h3")
	List<WebElement> cartitems;
	
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbtn;
	
	
	
	
	public Boolean validateItems() {
		
		
		return cartitems.stream().anyMatch(item->item.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		
		
		
		
		
	}
	
public paymentandAddress clickonCheckout() {
		
		
		checkoutbtn.click();
		paymentandAddress paymentpage = new paymentandAddress(driver);
		return paymentpage;
		
		
		
		
		
	}

}
