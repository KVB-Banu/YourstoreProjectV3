package authendication;

 
import java.util.HashMap; 

 
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import catalog.ACatalog;
import catalog.Catlist;
import frontEnd.FrontEnd;
import frontEnd.Gpay;
import frontEnd.PositiveTestCaseOnSignup;
import orders.CancelledOrders;
import orders.Filter;
import orders.LiveOrders;
import frontEnd.NegativeTC;
import productextras.Addon;
import productextras.MeasurementSets;
import productextras.productTags;

public class MainClass extends LoginDetails {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", driver_Path);
//	    ChromeOptions option = new ChromeOptions();
//	    option.addArguments("disable-notifications");
		
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();
		    
		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);
		    
		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();
		    
		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		LoginDetails login = new LoginDetails();
		login.signup();
//		login.loginSignup();
		Thread.sleep(5000);
		
		
		
		Signup genie = new Signup();
//		genie.genieSignup();
		
		ProSignup signup = new ProSignup();
		signup.proSignup();
		
		LoginSignup ls = new LoginSignup();
//		ls.genieSignup();

}
	
}