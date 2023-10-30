package automation.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class catalogueProducts extends automation.abstractclasses.Abstractclass {
	
	
	WebDriver driver;
	
	
	public catalogueProducts(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css=".mb-3")	
	List<WebElement> products;
	
	By locatorForElementWaiting = By.cssSelector(".mb-3");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getAllProducts() {
		waitElementToAppear(locatorForElementWaiting);
		return products;
	}
	
	public WebElement singleProduct() {
		WebElement prod= products.stream().filter(product->product.findElement(By.tagName("h5")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		 
		return prod;
		
		
		 
	}
	
	public void addToCart() {
		singleProduct().findElement(By.cssSelector("button:last-of-type")).click();
		waitElementToAppear(toastMessage);
		WebElement spinner = driver.findElement(By.cssSelector(".ng-animating"));
		waitElementToDisappear(spinner);
		
		
		
	}
	
}
