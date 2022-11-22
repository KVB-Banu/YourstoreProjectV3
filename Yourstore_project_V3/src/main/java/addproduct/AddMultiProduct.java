package addproduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddMultiProduct extends LoginDetails {

	static String[] productName = { "Altra Cologne", "FRESH UNISEX PERFUME", "Scuba Cologne", "Versace Bright Perfume",
			"Aqua Wave Perfume", "Carolina Herrera perfum", "Paco Rabanne Parfum", "Calvin Klein CK" };
	static String description = " The Branded Perfume";
	static String[] selling_Price = { "30000", "40000", "50000", "60000", "10000", "30000", "45000", "150000" };
	static String[] stock = { "10", "20", "10", "40", "12", "14", "30", "42" };
	static String[] image_path = { "C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image1.exe",
			"C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image7.exe",
			"C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image2.exe",
			"C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image3.exe",
			"C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image4.exe",
			"C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image5.exe",
			"C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image6.exe",
			"C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image8.exe" };
	static String[] image_label = { "Altra Cologne", "FRESH UNISEX PERFUME", "Scuba Cologne", "Versace Bright Perfume",
			"Aqua Wave Perfume", "Carolina Herrera perfum", "Paco Rabanne Parfum", "Calvin Klein CK" };
	public static String cat_value = "perfume";
	// static List<String> cat_values = Arrays.asList(cat_value);

	public static void add_MultiProduct() throws IOException, InterruptedException {

		// click on product start button
		// driver.findElement(By.xpath("(//span[contains(text(),'Start')])[1]")).click();//
		// click on start button

		Actions ac = new Actions(driver);

		driver.findElement(
				By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[2]/div[1]/div[2]/div[2]/h2[1]/a[1]"))
				.click();

		WebDriverWait wait1 = new WebDriverWait(driver, 20);

		Wait wait = new FluentWait(driver).withTimeout(5000, TimeUnit.MILLISECONDS).pollingEvery(1000, TimeUnit.SECONDS)
				.ignoring(Exception.class);

		try {
			
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
					"body > app-root > app-store-layout > div.app-admin-wrap.layout-sidebar-large > div.main-content-wrap.d-flex.flex-column.sidenav-open.top_space > app-product-sections > app-products > div > div.top-filter-sec.list-button.ng-tns-c90-9 > div > div.col-md-9.list-button.d-flex.justify-content-end.px-0.ng-tns-c90-9.ng-star-inserted > button:nth-child(5)")));
			WebElement addpro = driver.findElement(By.cssSelector(
					"body > app-root > app-store-layout > div.app-admin-wrap.layout-sidebar-large > div.main-content-wrap.d-flex.flex-column.sidenav-open.top_space > app-product-sections > app-products > div > div.top-filter-sec.list-button.ng-tns-c90-9 > div > div.col-md-9.list-button.d-flex.justify-content-end.px-0.ng-tns-c90-9.ng-star-inserted > button:nth-child(5)"));
			
			ac.moveToElement(addpro).build().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			driver.findElement(By.xpath("(//span[contains(text(),'add')])[3]")).click();

		}

//		 //click on view
//	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'add')])[3]")));
//	     
		List<String> productNames = Arrays.asList(productName);
		List<String> selling_Prices = Arrays.asList(selling_Price);
		List<String> stocks = Arrays.asList(stock);
		List<String> image_paths = Arrays.asList(image_path);
		List<String> image_labels = Arrays.asList(image_label);
		// List<String> cat_value = Arrays.asList(cat_values);

		for (int i = 0; i < productNames.size(); i++) {
			// driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			// Thread.sleep(4000);
			try {
				// driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
				try {

					WebElement addprod = driver.findElement(By.cssSelector(
							"body > app-root > app-store-layout > div.app-admin-wrap.layout-sidebar-large > div.main-content-wrap.d-flex.flex-column.sidenav-open.top_space > app-product-sections > app-products > div > div.top-filter-sec.list-button.ng-tns-c90-9 > div > div.col-md-9.list-button.d-flex.justify-content-end.px-0.ng-tns-c90-9.ng-star-inserted > button:nth-child(5) > span"));
					wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
							"body > app-root > app-store-layout > div.app-admin-wrap.layout-sidebar-large > div.main-content-wrap.d-flex.flex-column.sidenav-open.top_space > app-product-sections > app-products > div > div.top-filter-sec.list-button.ng-tns-c90-9 > div > div.col-md-9.list-button.d-flex.justify-content-end.px-0.ng-tns-c90-9.ng-star-inserted > button:nth-child(5) > span")));

					ac.moveToElement(addprod).click(addprod).build().perform();// click on add product
					Thread.sleep(2000);
				} catch (Exception e) {
					
					driver.findElement(By.xpath(
							"/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-products/div/div[2]/div/div[2]/button[5]"))
							.click();
				}

			} catch (Exception e) {

				System.out.println("Unable to find");

			}

			for (int j = 1; j < 4; j++) {

				// ac.click(image).build().perform();
				try {
					driver.findElement(By.xpath("(//i[normalize-space()='add_photo_alternate'])")).click();

				} catch (Exception e) {
					WebElement image = driver.findElement(By.xpath("(//i[normalize-space()='add_photo_alternate'])"));
					wait.until(ExpectedConditions.elementToBeClickable(image));
					ac.click(image).build().perform();
				}

				// "C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image7.exe"
				// "C:\\Users\\white\\OneDrive\\Desktop\\Jewel images\\image1.exe"

				if (j % 2 == 0) {
					Runtime.getRuntime().exec(image_path[i + 1]);
					Thread.sleep(2000);
					wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div/div[3]/p/span")));
					driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div/div[3]/p/span"))
							.click();// click on Crop

				}

				Runtime.getRuntime().exec(image_path[i]);
				Thread.sleep(1000);
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Save']")));
				driver.findElement(By.xpath("//button[normalize-space()='Save']")).click(); // click on save

			}

			driver.findElement(By.name("name")).sendKeys(productNames.get(i));
			driver.findElement(By.name("sku")).sendKeys("");
			Select s = new Select(driver.findElement(By.name("unit")));
			s.selectByIndex(0);
			driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys(description);

			driver.findElement(By.xpath("//input[@name='selling_price']")).sendKeys(selling_Prices.get(i));

			driver.findElement(By.name("stock")).sendKeys(stocks.get(i));
			Thread.sleep(1000);
//	      WebElement advOpt = driver.findElement(By.xpath("//*[@id=\"headingOne\"]/h5/button"));
//	      ac.click(advOpt).build().perform();

			JavascriptExecutor obj = (JavascriptExecutor) driver;
			obj.executeScript("window.scrollBy(0,600)");
			Thread.sleep(3000);
			
			WebElement catalog = driver.findElement(By.xpath("//span[contains(text(),'Bangle')]"));
			ac.click(catalog).build().perform();

			Thread.sleep(3000);

			// clicking on apply variant
			WebElement variant = driver.findElement(By.xpath("//b[normalize-space()='Apply Variants']"));
			ac.click(variant).build().perform();
			Thread.sleep(1000);

			Select s1 = new Select(driver.findElement(By.xpath(
					"/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-add-product/div/form/div[3]/div[2]/div/div/div/div[1]/select")));
			s1.selectByIndex(0);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[@id=\"options\"]/div/div/tag-input-form/form/input")).sendKeys("s", ",",
					"M", ",");
			Thread.sleep(1000);
			for (int j = 0; j < 1; j++) {
				try {
					driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[2]")).click();
					Thread.sleep(3000);
				} catch (Exception e) {
					driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[2]")).click();
					Thread.sleep(2000);
				}

				Runtime.getRuntime().exec(image_path[i]);
				Thread.sleep(2000);

				wait1.until(ExpectedConditions
						.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")));

				driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();

			}

			driver.findElement(By.xpath(
					"/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-add-product/div/form/div[3]/div[4]/div[1]/div/div/div[2]/div[2]/div/div[2]/input"))
					.sendKeys(stocks.get(i));
			driver.findElement(By.xpath("(//input[contains(@type,'tel')])[2]")).sendKeys("0.2");
			driver.findElement(By.xpath("(//input[contains(@type,'tel')])[3]")).sendKeys(selling_Prices.get(i));

			for (int j = 0; j < 1; j++) {
				try {
					driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[3]")).click();
					Thread.sleep(3000);
				} catch (Exception e) {
					driver.findElement(By.xpath("(//i[contains(text(),'add_photo_alternate')])[3]")).click();
					Thread.sleep(2000);
				}

				Runtime.getRuntime().exec(image_path[i + 1]);
				Thread.sleep(2000);
				wait1.until(ExpectedConditions
						.elementToBeClickable(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")));
				driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[2]")).click();
			}

			driver.findElement(By.xpath("(//input[contains(@type,'tel')])[4]")).sendKeys(stocks.get(i));
			driver.findElement(By.xpath("(//input[contains(@type,'tel')])[5]")).sendKeys("1");
			driver.findElement(By.xpath("(//input[contains(@type,'tel')])[6]")).sendKeys(selling_Prices.get(i));

			driver.findElement(By.name("brand")).sendKeys("GRT"); // Brand name
			driver.findElement(By.xpath("//input[@placeholder='Enter options']")).sendKeys("Thick bangle", ",",
					"two bangle", ",");

			// click on featured product
			driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[2]/div[1]/label/span[1]")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Apply Discount']")).click();
			driver.findElement(By.xpath("//input[@name='disc_percentage']")).sendKeys("10");
			Thread.sleep(3000);

			// Click on Addon

			if (i % 2 == 1) {
				driver.findElement(By.xpath("//span[normalize-space()='Apply Add-Ons']")).click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Choose Add-On Mandatory']")));

				WebElement addonMust = driver
						.findElement(By.xpath("//span[normalize-space()='Choose Add-On Mandatory']"));

				ac.click(addonMust).build().perform();

				driver.findElement(
						By.xpath("//*[@id=\"collapseOne\"]/div/div[3]/div[2]/div/div/div[2]/div[1]/label/span/span"))
						.click();

				Thread.sleep(3000);
				try {
					driver.findElement(By.cssSelector(
							"#collapseOne > div > div:nth-child(3) > div.row.ng-tns-c105-2.ng-star-inserted > div > div > div.row.mb-2.px-2.ng-tns-c105-2 > div:nth-child(1) > label > span > span"))
							.click();
					Thread.sleep(3000);
				} catch (Exception e) {
					driver.findElement(By.xpath("//span[contains(text(),'123')]")).click();
				}
				Thread.sleep(3000);
			}
			// click on size chart

			driver.findElement(By.xpath("//span[normalize-space()='Apply Size Chart']")).click();

			// obj.executeScript("window.scrollBy(0,2000)");
			Thread.sleep(3000);

			// Clicking on apply tags

			driver.findElement(By.xpath("(//span[normalize-space()='Apply Tags'])[1]")).click();
			// ac.click(tags).build().perform();
			Thread.sleep(1000);
			try {
				WebElement tag = driver
						.findElement(By.xpath("(//span[@class='ng-tns-c106-2'][normalize-space()='test'])[2]"));
				wait.until(ExpectedConditions.elementToBeClickable(tag));
				ac.click(tag).build().perform();
			} catch (Exception e) {
				driver.findElement(By.xpath("(//span[@class='ng-tns-c106-2'][normalize-space()='test'])[2]")).click();
			}
			// apply foot notes
			driver.findElement(By.xpath("(//span[normalize-space()='Apply Foot Note'])[1]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'12 inch')]")).click();

			// Apply FAQ
			driver.findElement(By.xpath("//span[normalize-space()='Apply FAQ']")).click();
			// apply image tag
			driver.findElement(By.xpath("//*[@id=\"collapseOne\"]/div/div[11]/div[1]/div/label")).click();

			driver.findElement(By.xpath("//span[@class='ladda-label']")).click();

			Thread.sleep(7000);
		}

	}

}
