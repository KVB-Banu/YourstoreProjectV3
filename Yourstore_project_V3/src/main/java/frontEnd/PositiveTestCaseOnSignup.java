package frontEnd;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PositiveTestCaseOnSignup extends LoginDetails {
	static String name = "Sumaiya";
	static String mobile_no = "7548657845";
	static String email = "kvbmbanu01@gmail.com";
	static String password ="ramesh";
	static String cfm_password = "ramesh";
	
	public void positiveTestCase() throws InterruptedException {
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    ChromeOptions option = new ChromeOptions();
    option.addArguments("incognito");
    capabilities.setCapability(ChromeOptions.CAPABILITY,option);
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\white\\OneDrive\\Desktop\\Driver Path\\chromedriver.exe");       
    driver= new ChromeDriver(capabilities);
	
	driver.get("https:/shop.yourstore.io/demostore/");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Actions ac = new Actions(driver);
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//span[@class='my-account-text']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
	System.out.println("User name: "+ name);
	driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile_no);
	System.out.println("Mobile No : "+ mobile_no);
	driver.findElement(By.id("email")).sendKeys(email);
	System.out.println("email: "+ email);
	driver.findElement(By.id("password")).sendKeys(password);
	System.out.println("password: "+ password);
	driver.findElement(By.name("confirm_pwd")).sendKeys(cfm_password);
	System.out.println("Confirm Password: "+ cfm_password);
	
	WebElement signup = driver.findElement(By.xpath("//button[normalize-space()='SIGN UP']"));
	System.out.println("Signup button is enabled : " + signup.isEnabled());
	
	if(signup.isEnabled()==false)
	{
		System.out.println("Signup is not enabled due to confirm password is not matching");
	}
	
	signup.click();
	try {
	WebElement error = driver.findElement(By.xpath("//div[@class='alert-msg d-flex align-items-center justify-content-center p-2']"));
	
	if(error.isDisplayed())
	{
	System.out.println("Error Message : " + driver.findElement(By.xpath("//div[@class='alert-msg d-flex align-items-center justify-content-center p-2']")).getText());
	System.out.println("Going to Signin");
	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.id("email")).sendKeys(email);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']")).click();
	
	}
	}catch(Exception e)
	{
		System.out.println("Error is not there");
	}
	
	Thread.sleep(2000);
	WebElement home = driver.findElement(By.linkText("Home"));
	ac.click(home).build().perform();
	}
	
	public void placingOrder() throws InterruptedException
	{
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,600)");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement collection = driver.findElement(By.xpath("//section[@class='grid-categories grid-sec-margin primary-section wow fadeInUp']//div[2]//div[1]//figure[1]//div[1]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='grid-categories grid-sec-margin primary-section wow fadeInUp']//div[2]//div[1]//figure[1]//div[1]")));
		Actions ac = new Actions(driver);
		ac.click(collection).build().perform();
		Thread.sleep(3000);
		
		WebElement product = driver.findElement(By.xpath("//div[@class='col-lg-9']//div[2]//div[1]//a[1]//figure[1]//img[2]"));
		ac.click(product).build().perform();
		Thread.sleep(2000);
			
			try {
				WebElement buyNow = driver.findElement(By.xpath("//button[normalize-space()='BUY NOW']"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='BUY NOW']")));
				
				
				if(buyNow.isEnabled())
				{
					
				 ac.click(buyNow).build().perform();
				}
				}catch(Exception e) {
					System.out.println("Buy Now option is not there");
				}
			
			try {			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='CUSTOMIZE YOUR GARMENT']")));
			WebElement cusYourGarment = driver.findElement(By.xpath("//button[normalize-space()='CUSTOMIZE YOUR GARMENT']"));
			
			obj.executeScript("window.scrollBy(0,400)");
			
			Thread.sleep(4000);			
			if(cusYourGarment.isEnabled())
			{

				ac.click(cusYourGarment).build().perform();
				
				driver.findElement(By.name("name")).sendKeys("Model1");
				driver.findElement(By.xpath("(//input[@name='option'])[3]")).click();
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("C:\\Users\\white\\OneDrive\\Documents\\ScreenShots\\cust.frontend.png"));
				
				driver.findElement(By.xpath("//button[normalize-space()='NEXT']")).click();
				driver.findElement(By.id("notes_name0")).sendKeys("petticoat1");
				driver.findElement(By.xpath("//button[normalize-space()='SUBMIT']")).click();
				driver.findElement(By.xpath("(//button[@class='primary-btn w-100 mb-0'][normalize-space()='ADD TO CART'])[1]")).click();
				driver.findElement(By.xpath("//button[@class='secondary-btn w-100 d-inline-flex justify-content-center align-items-center']")).click();
				obj.executeScript("window.scrollBy(0,600)");
				driver.findElement(By.xpath("//button[normalize-space()='CHECKOUT']")).click();
			}
			}catch(Exception e)
			{
				System.out.println("Customization option is not there");
			}
			
			System.out.println(driver.getTitle());
			
			
	
	
}
	
}
