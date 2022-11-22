package addproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddProductNegativeTC extends LoginDetails {
	
	static String name = "Necklace";
	static String selling_price = "35000";
	static int stock = 10;
	static String description = "A Pure gold bangle 24 kt";
	
	
	public void add() throws Exception  {
		
		
		driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[2]/div[1]/div[2]/div[2]/h2[1]/a[1]")).click();
		Actions ac= new Actions(driver);
		Thread.sleep(1000);
		
		try {
		WebElement addpro = driver.findElement(By.cssSelector("body > app-root > app-store-layout > div.app-admin-wrap.layout-sidebar-large > div.main-content-wrap.d-flex.flex-column.sidenav-open > app-product-sections > app-catalogs > div > div.top-filter-sec.list-button.mt-2.ng-tns-c70-1 > div > div.col-md-8.list-button.d-flex.justify-content-end.ng-tns-c70-1.ng-star-inserted > button:nth-child(3)"));
		ac.click(addpro).build().perform();
		Thread.sleep(1000);
		}catch(Exception e)
		{
			driver.findElement(By.xpath("(//span[contains(text(),'add')])[3]")).click();
		}

		for(int i=1; i<4; i++)
		{
		 

			driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/descendant::i")).get(0).click();
				
		
		if(i%2==0)
		{
			Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image7.exe");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div/div[3]/p/span")).click();//click on Crop
			
		}
		
		Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image1.exe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();// click on save
		
		}
		
		driver.findElement(By.name("name")).sendKeys(name);
		Select s= new Select(driver.findElement(By.name("unit")));
		s.selectByIndex(0);
		driver.findElement(By.name("selling_price")).sendKeys(selling_price);
		driver.findElement(By.name("stock")).sendKeys("10");
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys(description);
		Thread.sleep(1000);
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
			
    	WebElement catalogSearch = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		ac.click(catalogSearch).sendKeys(name).sendKeys(Keys.ENTER).build().perform();
//		catalogSearch.sendKeys(Keys.RETURN);
//		try {
//		List<WebElement> catalog = driver.findElements(By.xpath("//div[@class='form-group mb-3 px-2 checking ng-tns-c105-3 ng-star-inserted']"));
//    	for(WebElement x: catalog)
//    	{
//    		System.out.println("catalog list:" + x);	
//    	}
//		ac.click(catalogSearch).sendKeys(name).sendKeys(Keys.ENTER).build().perform();
//		}
		 
//		 Thread.sleep(3000);
//		 obj.executeScript("window.scrollBy(0,1000)");
//		 
//		 //clicking on apply variant
//		 WebElement variant = driver.findElement(By.xpath("//b[normalize-space()='Apply Variants']"));
//		 ac.click(variant).build().perform();
//		 Thread.sleep(1000);
//   	    
//		 Select s1 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-add-product/div/form/div[3]/div[2]/div/div/div/div[1]/select")));
//		 s1.selectByIndex(0);
//		 Thread.sleep(1000);
//		 
//		 driver.findElement(By.xpath("//*[@id=\"options\"]/div/div/tag-input-form/form/input")).sendKeys("s",",","M",",");
//		 Thread.sleep(1000);
//		 for(int j=0; j<3;j++)
//		 {
//		 try {
//		 driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[2]")).click();
//		 Thread.sleep(3000);
//		 }catch(Exception e)
//		 {
//			 driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[2]")).click(); 
//			 Thread.sleep(2000);
//		 }
//		 
//		 Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image1.exe");
//		 Thread.sleep(2000);
//		 
//		 driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();
//		 }
//		 
//		 driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-add-product/div/form/div[3]/div[4]/div[1]/div/div/div[2]/div[2]/div/div[2]/input")).sendKeys("10");
//		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[2]")).sendKeys("0.2");
//		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[3]")).sendKeys("40000");
//		 
//		 for(int j=0; j<3;j++)
//		 {
//		 try {
//		 driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[3]")).click();
//		 Thread.sleep(3000);
//		 }catch(Exception e)
//		 {
//			 driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[3]")).click();
//			 Thread.sleep(2000);
//		 }
//		 
//		 Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image7.exe");
//		 Thread.sleep(2000);
//		 
//		 driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();
//		 }
//		 
//		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[4]")).sendKeys("10");
//		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[5]")).sendKeys("1");
//		 driver.findElement(By.xpath("(//input[contains(@type,'tel')])[6]")).sendKeys("50000");
//		 
//		 driver.findElement(By.name("brand")).sendKeys("GRT"); // Brand name
//		 driver.findElement(By.xpath("//input[@placeholder='Enter options']")).sendKeys("Thick bangle", ",","two bangle",",");
//		 
//		 // click on featured product
//		 driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div[1]/label/span[1]")).click(); 
//		 driver.findElement(By.xpath("//span[normalize-space()='Apply Discount']")).click();
//		 driver.findElement(By.xpath("//input[@name='disc_percentage']")).sendKeys("10");
//		 Thread.sleep(3000);
//		 
//		 // Click on Addon
//		 
//		 
////		 driver.findElement(By.xpath("//span[normalize-space()='Apply Add-Ons']")).click();
////		
////		 try {
////		 driver.findElement(By.name("addon_must")).click();// add on must click on
////		 }catch(Exception e) {
////			 driver.findElement(By.xpath("#collapseOne > div > div:nth-child(3) > div.row.ng-tns-c105-2.ng-star-inserted > div > div > div.mb-3.d-flex.justify-content-end.ng-tns-c105-2 > label > span.checkmark.ng-tns-c105-2")).click();
////		 }
////		 
////		 
////			 driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[3]/div[2]/div/div/div[2]/div[1]/label/span/span")).click();
////			 
//////		 }catch(Exception e)
//////		 {
//////			 driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[3]/div[2]/div/div/div[1]/label/span[2]")).click();
//////		 }
////		 
////		 Thread.sleep(3000);
////		 try {
////		 driver.findElement(By.cssSelector("#collapseOne > div > div:nth-child(3) > div.row.ng-tns-c105-2.ng-star-inserted > div > div > div.row.mb-2.px-2.ng-tns-c105-2 > div:nth-child(1) > label > span > span")).click();
////		 Thread.sleep(3000);
////		 }catch(Exception e)
////		 {
////			 driver.findElement(By.xpath("//span[contains(text(),'123')]")).click();
////		 }
////		 
//		 // click on size chart
//		 
//		 driver.findElement(By.xpath("//span[normalize-space()='Apply Size Chart']")).click();
//		 Thread.sleep(3000);
//		 
//		 //Clicking on apply tags
//		 
//		  driver.findElement(By.xpath("(//span[normalize-space()='Apply Tags'])[1]")).click();
//		 //ac.click(tags).build().perform();
//		 Thread.sleep(1000);
//		 driver.findElement(By.xpath("(//span[@class='ng-tns-c106-2'][normalize-space()='test'])[2]")).click();
//		 
//		 // apply foot notes
//		 driver.findElement(By.xpath("(//span[normalize-space()='Apply Foot Note'])[1]")).click();
//		 driver.findElement(By.xpath("//span[contains(text(),'12 inch')]")).click();
//		 
//		 //Apply FAQ
//		 driver.findElement(By.xpath("//span[normalize-space()='Apply FAQ']")).click();
//		 // apply image tag
//		 driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[11]/div[1]/div/label")).click();
//		 
//		 driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
//		 
		 
	}
	

}


