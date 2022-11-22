package addproduct;

import org.openqa.selenium.By;

public class Offers extends LoginDetails {
	public void offers()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Marketing Tools']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Offers']")).click();
	}

}
