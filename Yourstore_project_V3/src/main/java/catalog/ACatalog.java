package catalog;

import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import catalog.LoginDetails;

public class ACatalog extends LoginDetails{
	
	static String name = "YourStore2";
	static String description = "kjfhg jdbgkjf  jnbdkjfdg kjkdjgkjd";
	
   public void clickPro() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
		
	   }
	   
		
   public void addCat() throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		driver.findElement(By.xpath("//button[@routerlink='/product-sections/catalogs/add']")).click();
		driver.findElement(By.xpath("//i[@class='material-icons add-img']")).click();
		
		Runtime.getRuntime().exec("C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image4.exe");
		Thread.sleep(4000);
		driver.findElement(By.name("name")).sendKeys(name);
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		obj.executeScript("window.scrollBy(0,300)");
		
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys(description);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Enable Page Content']")));
		driver.findElement(By.xpath("//span[normalize-space()='Enable Page Content']")).click();
		
		
		obj.executeScript("window.scrollBy(0,600)");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.name("title")));
		driver.findElement(By.name("title")).sendKeys("yourstr");
		
		driver.findElement(By.xpath("//quill-editor[@class='rounded ng-untouched ng-pristine ng-valid']//div[@class='ql-editor ql-blank']")).sendKeys(description);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Enable Social Media Links']")));
		driver.findElement(By.xpath("//span[normalize-space()='Enable Social Media Links']")).click();
		
		
//		try {
//		       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='light-button']")));
//		       System.out.println("Element is clickable");
//		     }
//		catch(TimeoutException e) {
//		       System.out.println("Element isn't clickable");
//		    }
		
		
		driver.findElement(By.xpath("//button[@class='light-button']")).click();
		Thread.sleep(4000);
		
		obj.executeScript("window.scrollBy(0,400)");
	//	driver.switchTo().frame(0);
		Select s = new Select(driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-catalog-event/div/form/div[1]/div[2]/div[1]/div[7]/div/div/div/div/div[1]/select")));
		s.selectByIndex(0);
				
	    List<WebElement> op = s.getOptions();
		 		
		for(int i=0; i<op.size();i++)
		{
			
			String options = op.get(i).getText();
			System.out.println("options are : " + options);
			
		}
		Thread.sleep(1000);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")));
		driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")).sendKeys("/facebook");
		}catch(Exception e) {
		driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div/app-product-sections/app-catalog-event/div/form/div[1]/div[2]/div[1]/div[7]/div/div/div/div/div[2]/input")).sendKeys("/facebook");
		}
		
		Thread.sleep(3000);
				
		String link = driver.findElement(By.xpath("//p[@class='light-font font-10 mb-1 ng-star-inserted']")).getText();
		System.out.println(link);
		
		
		driver.findElement(By.xpath("//span[@class='ladda-label']")).click();
		
		Thread.sleep(3000);
		
		WebElement error = driver.findElement(By.xpath("/html/body/app-root/app-store-layout/div[1]/div/app-product-sections/app-catalog-event/div/form/div[3]/div[1]/p"));
		
		
		if(error.isDisplayed())
		{
			System.out.println("Error Message is:" + error.getText());
			try {
		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='black-outline-txt']")));
			System.out.println("Cancel button is clickable");
			}catch(Exception e)
			{
				System.out.println("Cancel button is not clickable");
			}
			
		}
		 driver.findElement(By.xpath("//span[@class='black-outline-txt']")).click();
		 System.out.println("cancelled");
		
		
	}
	
	public void catalogCompare() throws Exception {
		
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")));
		  List<WebElement> catalogNames = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]"));
		 
		  System.out.println("catalognames size: " + catalogNames.size());
		 for(int j =0; j<2; j++)
		 {
			  
		  for(int i =0; i<(catalogNames.size()-1); i++)
		  {
			
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")));
			  WebElement catalogNames1 = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/child::div/child::div[2]//div/descendant::div//div/following-sibling::div/descendant::p[1]")).get(i+1);
			  String a = catalogNames1.getText();
			  System.out.println(a);
			  
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/descendant::div[2]/descendant::div[5]/child::button[contains(text(),'Add Product')]")));
			  driver.findElement(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open']/child::app-product-sections/child::app-catalogs/descendant::div[2]/descendant::div[5]/child::button[contains(text(),'Add Product')]")).click();
			  Thread.sleep(3000);
			  
			  JavascriptExecutor obj = (JavascriptExecutor) driver;
			  obj.executeScript("window.scrollBy(0,610)");
			  
			  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/child::div[8]/descendant::div[2]/following-sibling::div/descendant::label/child::span")));
			  List<WebElement> catalogElementsNameInProduct = driver.findElements(By.xpath("//div[@class='main-content-wrap d-flex flex-column sidenav-open top_space']/descendant::app-add-product/descendant::form/child::div[2]/child::div[8]/descendant::div[2]/following-sibling::div/descendant::label/child::span"));
			  
			  for(WebElement x : catalogElementsNameInProduct)
				{
					String text = x.getText();
				
					//	System.out.println("Add on Names in Add product : " + text);
					Thread.sleep(4000);
					
					if(a.contains(text))
					{
						System.out.println(text + " Catalog option is present"  );
	
					break;
					}
					
				}
			  
			  clickPro();
			  Thread.sleep(4000);
			  
			  
		  }
		  
		  driver.findElement(By.xpath("//pagination-controls[@responsive='true']/descendant::ul/child::li[5]/child::a")).click();
		  
	} 
		 
		
		
	}
	
	

}
