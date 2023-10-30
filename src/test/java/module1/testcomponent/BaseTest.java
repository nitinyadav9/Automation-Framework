package module1.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automation.classes.loginpage;

public class BaseTest {
	
	public WebDriver driver;
	public loginpage lp;
	public void initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\automation\\resources\\Globaldata.properties");
		prop.load(fs);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			
			//firefox
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
	}
	
	
	public List<Map<String, String>> getDataFromJson() {
		
		
		File fileobj = new File("D:\\Automation framework\\SeleniumFrameworkDesign\\src\\test\\java\\module1\\data\\PurchaseOrder.json");
		 ObjectMapper mapper = new ObjectMapper();  
		 
		 List <Map<String, String> > userData = null;
		    try {  

	            userData = mapper.readValue(  
	                    fileobj, new TypeReference<List<Map<String, String>>>() {  
	            });
	          return userData;
		    }
		    catch(Exception ex) {
		    	System.out.println(ex);
		    }
			
		return userData;
		   
	}
	@BeforeMethod
	public loginpage launchApplication() throws IOException {
		initializeDriver();
		
		lp = new loginpage(driver);
		lp.Goto();
		
		return lp;
		
		
	}
	
	@AfterMethod
	public void closeBrowser() throws IOException {
		driver.close();
		
	}
}
