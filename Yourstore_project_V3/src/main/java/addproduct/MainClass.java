package addproduct;

 
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
		login.login();
		Thread.sleep(5000);

		 AddProduct add_Prod = new AddProduct();
		 add_Prod.add();
		 
		 AddProductNegativeTC nap = new AddProductNegativeTC();
		 nap.add();
	
//		 AddMultiProduct addMul = new AddMultiProduct();
//		 addMul.add_MultiProduct();

		
//      // Front end
//		 FrontEnd fend = new FrontEnd();
//		 fend.log();
//		 fend.frontEnd();

		//using all payment gateway
//		 Gpay gpay = new Gpay();
//		 gpay.log();
//		 gpay.usingGpayPayment();

		
//		 PositiveTestCaseOnSignup ptc = new PositiveTestCaseOnSignup();
//		 ptc.positiveTestCase();
//		 ptc.placingOrder();

		
//		 NegativeTC ntc = new NegativeTC();
//		 ntc.log();
//		 ntc.negativeTestCase();
//		 ntc.signinNegativeTC();
//	     ntc.placingOrder();
		 
		 
//	  // Live Orders
//		 LiveOrders ord = new LiveOrders();
//		 ord.liveOrders();
//		 ord.markAsPaid();
//		 ord.statusConfirmed();
//		 ord.courierPartner();
//		 ord.statusDispatched();
//		 ord.statusDelivered();
		
		//Filter
//		Filter flt =new Filter();
//		flt.liveOrders();
//		flt.filter();
//		
		//Cancel Order
//		CancelledOrders cancelOrd = new CancelledOrders();
//		cancelOrd.liveorders();
//		cancelOrd.cancelOrder();
//		cancelOrd.cancelledOrder();
		
		 
		 // product Extras - Measurement Sets
		MeasurementSets ms = new MeasurementSets();
//		ms.clickProd();
//		ms.measure();
//    	ms.search();
//		ms.editView();
//		ms.remove(); 
		
		


		
	
		
		
		

	}
	
	
	

}
