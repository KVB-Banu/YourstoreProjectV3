package authendication;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginDetails {
	
	public final static String driver_Path= "C:\\Users\\white\\OneDrive\\Desktop\\Driver Path\\chromedriver.exe";
    public final static String url = "https://yourstore.io";
    public final static String name = "Storehook";
    public final static String mobile_num ="1234567890";
	public final static String email ="banuyourstore@gmail.com";
	public final static String password ="Banu@Yourstore.io";
	public static WebDriver driver;	
	public final static String store_name ="StoreHook";
	public final static String address = "14, Gulmohar Avenue, Velachery Rd, Guindy, Chennai, Tamil Nadu 600032";
	public final static String city = "Chennai";
	public final static String pincode = "600032";
	public final static String GST = "6358734987664364";
	public final static String description ="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
	
	
	
public void signup() throws InterruptedException {
	    
	driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/div/div[2]/a/button")).click();
	JavascriptExecutor obj = (JavascriptExecutor) driver;
	obj.executeScript("window.scrollBy(0,500)");

//	driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(0).click(); // start button=> genie sign up
	driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(1).click(); // start button=> pro sign up
//	driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(2).click(); // start button=> Multi vendor sign up
//	driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(3).click(); // start button=> B2B sign up
//	driver.findElements(By.xpath("//button[contains(text(),'Sign up')]")).get(4).click(); // start button=> service sign up
	}

public void loginSignup() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver,20);
    
	driver.findElement(By.xpath("//div[@class='main-menu d-flex align-items-center justify-content-end']//a[contains(text(),'Login')]")).click();
	
	String parent = driver.getWindowHandle();

	Set<String> s = driver.getWindowHandles();

	Iterator<String> I1 = s.iterator();

	while (I1.hasNext()) {

		String child_window = I1.next();

		if (!parent.equals(child_window)) {
			driver.switchTo().window(child_window);

			System.out.println(driver.switchTo().window(child_window).getTitle());


	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='ng-tns-c67-0 ng-untouched ng-pristine ng-invalid']/child::div[3]/descendant::strong[contains(text(),'Signup')]")));
	driver.findElement(By.xpath("//form[@class='ng-tns-c67-0 ng-untouched ng-pristine ng-invalid']/child::div[3]/descendant::strong[contains(text(),'Signup')]")).click();

		}	
	}

  }
}
