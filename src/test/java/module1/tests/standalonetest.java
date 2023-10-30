package module1.tests;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.classes.cartPage;
import automation.classes.catalogueProducts;
import automation.classes.confirmationPage;
import automation.classes.loginpage;
import automation.classes.orderPage;
import automation.classes.paymentandAddress;
import module1.testcomponent.BaseTest;
public class standalonetest extends BaseTest {

	@Test(dataProvider="dataprovider")
	public void submitOrder(HashMap<String,String> input) throws IOException {
		
		
		

		
		catalogueProducts products  = lp.clickonLoginButton(input.get("email"), input.get("password"));

		
		products.addToCart();
		
		cartPage cart = products.goToCart();
		
		
		Boolean match = cart.validateItems();
		Assert.assertTrue(match);
		paymentandAddress paymentpage =cart.clickonCheckout();
		
		
		paymentpage.selectCountry();
		
		confirmationPage confirmmessage = paymentpage.submitOrder();
		
		
		
		String thankyou= confirmmessage.confirMessage();
		
		Assert.assertTrue(thankyou.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	
	@Test(dependsOnMethods = { "submitOrder" })
	public void verifyProductOnOrdersPage() {
		catalogueProducts products  = lp.clickonLoginButton("nitin.n9@gmail.com", "Iamking@000");
		
		orderPage orders = products.goToOrderPage();
		
		Boolean b = orders.verfiyproduct();
		
		Assert.assertTrue(b);
		
		
		
		
	}
	

	
	@DataProvider
	public Object[][] dataprovider() throws IOException, ParseException {
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "nitin.n9@gmail.com");
//		map.put("password","Iamking@000");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "nitin.n99@gmail.com");
//		map1.put("password","Iamking@000");
		
		List<Map<String, String>> b = getDataFromJson();
		
		return new Object[][] {{b.get(0)},{b.get(1)}};
		
	}
	
	
}