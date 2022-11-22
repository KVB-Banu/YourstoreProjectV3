package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginDetails {
	
	public final static String driver_Path= "C:\\Users\\white\\OneDrive\\Desktop\\Driver Path\\chromedriver.exe";
    public final static String url = "https://yourstore.io/login/session/signin";
	public final static String email ="demo302@yourstore.io";
	public final static String password ="admin747@Yourstore2";
	public static WebDriver driver;	
	
	
public void login() {
	    
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/app-root/app-auth-layout/div/div/app-signin/div/div/div/div/form/div[3]/div[3]/btn-loading/button")).click();
		
		
		
	}


}
