package automation.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentandAddress {
	
	WebDriver driver;
	public paymentandAddress(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	
	@FindBy(css="input[placeholder='Select Country")
	WebElement country;
	
	@FindBy(css=".ta-item:last-of-type")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	
	
	public void selectCountry() {
		country.sendKeys("india");
		
		
		selectCountry.click();
//		driver.findElement(By.cssSelector(".action__submit")).click();
		
		
	}
	public confirmationPage submitOrder() {
		placeorder.click();
		
		confirmationPage confirmorder=new confirmationPage(driver);
		
		return confirmorder;
	}

}
