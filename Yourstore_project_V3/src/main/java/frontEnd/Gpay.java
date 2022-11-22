package frontEnd;

import java.io.File; 
import java.io.IOException;
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

public class Gpay extends LoginDetails{
	
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
	
	public void usingGpayPayment() throws InterruptedException, IOException
	{
		
		Actions ac = new Actions(driver);
		for(int i=0; i<5; i++)
		{
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,600)");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='category custom-grid']/child::figure/child::div")));
		WebElement collection = driver.findElements(By.xpath("//div[@class='category custom-grid']/child::figure/child::div")).get(i);
		ac.click(collection).build().perform();
			
		Thread.sleep(3000);
		   
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='cat-grid col-sm-6 col-6 pr-0 d-flex col-md-4']"));
		
		
			ac.click(products.get(i)).build().perform();
			Thread.sleep(2000);
			
			try {
				WebElement buyNow = driver.findElement(By.xpath("//button[normalize-space()='BUY NOW']"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='BUY NOW']")));
				
				
				if(buyNow.isEnabled())
				{
					
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='pay-now']")));
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
			
			
			
			//	driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='CONFIRM'])[1]")).click();
				driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='CONFIRM'])[2]")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.id("code")).sendKeys("MANUAL01");
				driver.findElement(By.xpath("//button[normalize-space()='APPLY']")).click();
				
				//System.out.println("Coupon Code is : " + driver.findElement(By.xpath("//span[@class='smooth-fadein m-0 d-flex align-items-center justify-content-center error-bg']")).getText());
				Thread.sleep(4000);
				System.out.println("SubTotal : " + driver.findElement(By.cssSelector("#app-root > app-checkout-header > div > div > app-product-order-details > section > section.common-site-section.shopping-cart > div > div > div > div > div:nth-child(2) > div > div.product-order-type-inner.pt-3 > div > div:nth-child(2) > span")).getText());	
				System.out.println("Shipping : " + driver.findElement(By.xpath("//body[1]/app-root[1]/app-checkout-header[1]/div[1]/div[1]/app-product-order-details[1]/section[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/span[1]")).getText());
				System.out.println("Discount : " + driver.findElement(By.xpath("//body[1]/app-root[1]/app-checkout-header[1]/div[1]/div[1]/app-product-order-details[1]/section[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[6]/span[1]")).getText());
				System.out.println("Amount Payable : " + driver.findElement(By.cssSelector("div[class='col-6 d-flex align-items-start justify-content-end m-0 mt-3 mb-3'] span[class='m-0']")).getText());
          
				obj.executeScript("window.scrollBy(0,620)");
				Thread.sleep(2000);
				
				List<WebElement> payment_Methods = driver.findElements(By.xpath("//button[@class ='primary-btn w-100 mb-1']"));
				
				if(i==0) {
				String text = payment_Methods.get(i).getText();
				payment_Methods.get(i).click();
				System.out.println("Paid by :" + text);
				driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO NEXT STEP']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@name='payment_id']")).sendKeys("kvbmbanu-1@okaxis");
				driver.findElement(By.xpath("//button[normalize-space()='CONFIRM']")).click();
				Thread.sleep(10000);
				}
				else if(i==1) {
					String text = payment_Methods.get(i).getText();
					payment_Methods.get(i).click();
					System.out.println("Paid by :" + text);
					
					driver.findElement(By.xpath("//button[@type='button'][normalize-space()='PLACE ORDER']")).click();
				}
				
				else if(i==2)
				{
					String text = payment_Methods.get(i).getText();
					payment_Methods.get(i).click();
					System.out.println("Paid by :" + text);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@type='submit'][normalize-space()='PLACE ORDER']")).click();
				}
				
				else if(i==3) {
					String text = payment_Methods.get(0).getText();
					payment_Methods.get(0).click();
					System.out.println("Paid by :" + text);
					driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO NEXT STEP']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@name='payment_id']")).sendKeys("kvbmbanu-1@okaxis");
					driver.findElement(By.xpath("//button[normalize-space()='CONFIRM']")).click();
					Thread.sleep(10000);
					}
				
				else if(i==4)
				{
					String text = payment_Methods.get(i).getText();
					payment_Methods.get(i).click();
					System.out.println("Paid by :" + text);
					Thread.sleep(5000);
					System.out.println(driver.getTitle());
					System.out.println(driver.getCurrentUrl());
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Pay using BHIM, GPay and other UPI apps']")));
					driver.findElement(By.xpath("//span[normalize-space()='Pay using BHIM, GPay and other UPI apps']")).click();
					Thread.sleep(2000);
					
			//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='active']//strong")));
					driver.findElement(By.xpath("//input[@name='vpa']")).sendKeys("kvbmbanu-1@okaxis");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@id='pay-now']")).click();
					Thread.sleep(5000);
				}
				
				Thread.sleep(3000);
				String or = driver.findElement(By.xpath("//*[@id=\"app-root\"]/app-checkout-header/div/div/app-order-summary/section/section[2]/div/div[1]/div/p")).getText();
				System.out.println("Order : " +or);
				
				System.out.println("****************************** Order is Placed ********************************");
				
				Thread.sleep(1000);
				WebElement home = driver.findElement(By.linkText("Home"));
				ac.click(home).build().perform();
				
				Thread.sleep(2000);
				
				
			}
			
		}
		
	}
	
	


