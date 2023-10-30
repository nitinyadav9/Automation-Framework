package module1.tests;


import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation.classes.loginpage;
public class standalonetest2 {

	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		loginpage lp = new loginpage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("nitin.n9@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		
		WebElement prod= products.stream().filter(product->product.findElement(By.tagName("h5")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector("button:last-of-type")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='/cart']")).click();
		
		
		List<WebElement> cartitems=  driver.findElements(By.cssSelector("[class='cartSection'] h3"));
		
		Boolean a =cartitems.stream().anyMatch(item->item.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		
		Assert.assertTrue(a);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
		
		
		driver.findElement(By.cssSelector(".ta-item:last-of-type")).click();
		
		
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String thank= driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(thank.contains("THANKYOU FOR THE ORDER."));
	}
	
}