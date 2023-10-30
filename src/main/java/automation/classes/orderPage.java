package automation.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class orderPage {
	
	WebDriver driver;
	public orderPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	
	@FindBy(css="[class='cartSection'] h3")
	List<WebElement> cartitems;
	
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbtn;
	
	
	
	
	public Boolean verfiyproduct() {
		
		
		List<WebElement> allProducts  =driver.findElements(By.cssSelector("tr[class='ng-star-inserted'] td:nth-child(3)"));
		
		Boolean b = allProducts.stream().anyMatch(prod->prod.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		return b;
		
		
		
		
		
		
	}
	

}
