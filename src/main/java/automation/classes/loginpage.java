package automation.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.abstractclasses.Abstractclass;

public class loginpage extends Abstractclass{

	
	
	WebDriver driver;
	
	
	public loginpage(WebDriver driver) {
		
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	} 
	
	
//	driver.findElement(By.id("userEmail")).sendKeys("nitin.n9@gmail.com");
//	driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
//	driver.findElement(By.id("login")).click();
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement sbtbutton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public catalogueProducts clickonLoginButton(String email, String pass) {
		userEmail.sendKeys(email);
		userpassword.sendKeys(pass);
		
		sbtbutton.click();
		catalogueProducts products = new catalogueProducts(driver);
		return products;
		
	}
	
	public String errorMessageonInvalidCred() {
		waitWebElementToAppear(errorMessage);
		String errorMsg =errorMessage.getText();
		
		return errorMsg;
	}

	
	

	
}
