package frontEnd;

import java.io.File; 
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;



public class FrontEnd extends LoginDetails{
	
//	private static final File DestFile = null;
//	static WebDriver driver;
//	
	//private String orderNum; 
	
	public void log() throws InterruptedException {
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("incognito");
	    capabilities.setCapability(ChromeOptions.CAPABILITY,option);
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\white\\OneDrive\\Desktop\\Driver Path\\chromedriver.exe");       
	    driver= new ChromeDriver(capabilities);
		
		driver.get("https:/shop.yourstore.io/demostore/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		Actions ac = new Actions(driver);
		
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[@class='my-account-text']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("kvbmbanu@gmail.com");
		driver.findElement(By.id("password")).sendKeys("ramesh");
		driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']")).click();
		Thread.sleep(2000);
		WebElement home = driver.findElement(By.linkText("Home"));
		ac.click(home).build().perform();
	}
	
		public void frontEnd() throws InterruptedException, IOException {
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement collection = driver.findElement(By.xpath("(//div[@class='category custom-grid'])[1]"));
		Actions ac = new Actions(driver);
		
		   Thread.sleep(3000);
			ac.click(collection).build().perform();
			
			WebElement product = driver.findElement(By.xpath("//body[1]/app-root[1]/app-main-header[1]/div[1]/div[1]/app-category[1]/section[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/a[1]/figure[1]/img[2]"));
			
			
//			WebElement product = driver.findElement(By.xpath("(//img[@alt='product-img'])[2]"));
			
				Thread.sleep(4000);
				ac.click(product).build().perform();
//				Thread.sleep(5000);
//				
//				WebElement cusYourGarment = driver.findElement(By.xpath("//button[normalize-space()='CUSTOMIZE YOUR GARMENT']"));
//				
                WebElement buyNow= driver.findElement(By.xpath("//button[normalize-space()='BUY NOW']"));
                ac.click(buyNow).build().perform();
//				
//			    System.out.println(cusYourGarment.isDisplayed());
//			    Thread.sleep(1000);
//				ac.click(cusYourGarment).build().perform();
//				
//				Thread.sleep(4000);
//				
//				driver.findElement(By.name("name")).sendKeys("Model1");
//				driver.findElement(By.xpath("(//input[@name='option'])[3]")).click();
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("C:\\Users\\white\\OneDrive\\Documents\\ScreenShots\\cust.frontend.png"));
//				
//				driver.findElement(By.xpath("//button[normalize-space()='NEXT']")).click();
//				driver.findElement(By.id("notes_name0")).sendKeys("petticoat1");
//				driver.findElement(By.xpath("//button[normalize-space()='SUBMIT']")).click();
//				driver.findElement(By.xpath("(//button[@class='primary-btn w-100 mb-0'][normalize-space()='ADD TO CART'])[1]")).click();
//				driver.findElement(By.xpath("//button[@class='secondary-btn w-100 d-inline-flex justify-content-center align-items-center']")).click();
//				
//				driver.findElement(By.xpath("//button[normalize-space()='CHECKOUT']")).click();
		//		driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='CONFIRM'])[1]")).click();
				driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='CONFIRM'])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("code")).sendKeys("MANUAL01");
				driver.findElement(By.xpath("//button[normalize-space()='APPLY']")).click();
				Thread.sleep(4000);
				System.out.println("SubTotal : " + driver.findElement(By.cssSelector("#app-root > app-checkout-header > div > div > app-product-order-details > section > section.common-site-section.shopping-cart > div > div > div > div > div:nth-child(2) > div > div.product-order-type-inner.pt-3 > div > div:nth-child(2) > span")).getText());	
				System.out.println("Shipping : " + driver.findElement(By.xpath("//body[1]/app-root[1]/app-checkout-header[1]/div[1]/div[1]/app-product-order-details[1]/section[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/span[1]")).getText());
				System.out.println("Discount : " + driver.findElement(By.xpath("//body[1]/app-root[1]/app-checkout-header[1]/div[1]/div[1]/app-product-order-details[1]/section[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[6]/span[1]")).getText());
				System.out.println("Amount Payable : " + driver.findElement(By.cssSelector("div[class='col-6 d-flex align-items-start justify-content-end m-0 mt-3 mb-3'] span[class='m-0']")).getText());
				
				List<WebElement> payment_Method = driver.findElements(By.xpath("//button[@class ='primary-btn w-100 mb-1']"));
				
				
				driver.findElement(By.xpath("//button[normalize-space()='Pay With Google Pay']")).click();
				driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO NEXT STEP']")).click();
				driver.findElement(By.xpath("//input[@name='payment_id']")).sendKeys("kvbmbanu-1@okaxis");
				driver.findElement(By.xpath("//button[normalize-space()='CONFIRM']")).click();
				Thread.sleep(10000);
				WebElement or = driver.findElement(By.xpath("//*[@id=\"app-root\"]/app-checkout-header/div/div/app-order-summary/section/section[2]/div/div[1]/div/p"));
				ac.doubleClick(or).doubleClick(or).build().perform();
//				String ord = or.getText();
//				ord = ord.substring(1);
				FileUtils.copyFile(screenshot, new File("C:\\Users\\white\\OneDrive\\Documents\\ScreenShots\\billing.frontend.png"));
				ac.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
				System.out.println("*******************************Front End Closed******************************");
				driver.close();	
		}
				
		
						
		}
		
		
		

			
		
		
	
