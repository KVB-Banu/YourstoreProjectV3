package productextras;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import productextras.LoginDetails;

public class PEMainClass extends LoginDetails{
	
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
		login.login();
		Thread.sleep(5000);
		
		Addon ao = new Addon();
//		ao.clickPro();
//		ao.addAddOn();
//		ao.edit();
//		ao.addOnCompare();
//		ao.search();
//		ao.remove();
//      ao.buttonSettings(); 
		
			
		MeasurementSets ms = new MeasurementSets();
//		ms.clickProd();
//		ms.measure();
//		ms.search();
//		ms.editView();
//		ms.remove();
		
		productTags tags = new productTags();
//		tags.clickPro();
//		tags.addProdTags();
//		tags.search();
//		tags.tagCompare();
		
		FootNote fn = new FootNote();
//		fn.clickPro();
//		fn.AddFN();
//		fn.search();
//		fn.compareFootNote();
//		fn.compareOptions();
//		fn.remove();
		
		SizeChart sc = new SizeChart();
//		sc.clickPro();
//		sc.addSizeChart();
//		sc.search();
//		sc.edit();
//		sc.compareSizeChart();
//      sc.remove();	

		FAQ faq = new FAQ();
//		faq.clickPro();
//		faq.AddFAQ();
//		faq.search();
//		faq.compareAnswers();
//		faq.faqCompare();
//		faq.remove();
		
		
		ImageTags imgTags = new ImageTags();
//		imgTags.clickPro();
//		imgTags.AddTags();
//		imgTags.search();
//		imgTags.edit();
//		imgTags.compareImageTags();
//		imgTags.remove();
//		imgTags.disableOrEnable();
		
		
		
     }
	
}
