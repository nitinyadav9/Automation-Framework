package automation.abstractclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.classes.cartPage;
import automation.classes.orderPage;

public class Abstractclass {
	WebDriver driver;
	
	
	
	
	public Abstractclass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="[routerlink*='/cart']")
	WebElement cartLink;
	
	@FindBy(css="[routerlink*='/myorders']")
	WebElement orderPageLink;

	public cartPage goToCart() {
		
		cartLink.click();
		
		cartPage cart = new cartPage(driver);
		return cart;
	}
	
public orderPage goToOrderPage() {
		
		orderPageLink.click();
		
		orderPage orders = new orderPage(driver);
		return orders ;
	}

	public void waitElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	public void waitWebElementToAppear(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	public void waitElementToDisappear(WebElement spinner) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
}
