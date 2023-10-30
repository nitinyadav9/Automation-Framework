package module1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import module1.testcomponent.BaseTest;

public class errorValidationTest extends BaseTest{
	
	@Test
	public void submitOrder() {
		
		lp.clickonLoginButton("nitin.n9@gmail.com", "Iking@000");
		
		String error= lp.errorMessageonInvalidCred();
		Assert.assertEquals("Incorrect email or password.", error);
	}
	
}
