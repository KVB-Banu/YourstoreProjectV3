package DashBoard;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LogoPage extends LoginDetails{
	
	static String[] logo_Path = {"C:\\Users\\white\\OneDrive\\Desktop\\LOGO\\AutoITLogoscript\\test03UploadScript.exe"}; 
	
	public static void Logo() throws InterruptedException, IOException
	{
		Actions ac = new Actions(driver);
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click(); // click on start button
	    Thread.sleep(3000);
	    WebElement browse = driver.findElement(By.xpath("//input[@name='store_logo']"));
	    ac.click(browse).build().perform();// click on browse button
	    Thread.sleep(1000);
	    Runtime.getRuntime().exec(logo_Path);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@class='col-md-12 ng-star-inserted']//div[5]//label[1]//span[1]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@class='col-md-12 mt-3 ng-star-inserted']//div[5]//label[1]//span[1]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[normalize-space()='Update']")).click(); // click on update button
	   // driver.findElement(By.xpath("//button[normalize-space()='Continue Setup']")).click();
	    driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-logo-management/div/div[1]/div/div[2]/button")).click();
	}

}
