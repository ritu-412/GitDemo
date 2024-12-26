package CoreJavaBasics;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class indigohp {
	WebDriver driver;
	WebDriverWait wait ;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("https://www.booking.com/");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			// Set script timeout
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

			// Set implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='abcc616ec7 cc1b961f14 c180176d40 f11eccb5e8 ff74db973c']/button")).click();
			Thread.sleep(2000);
			WebElement from = driver.findElement(By.xpath("//div[@class='e000754250']/input[@name='ss']"));
			from.click(); 

			from.sendKeys("kolkata");
			Thread.sleep(2000);
			List <WebElement> source_destinations = driver.findElements(By.xpath("//div[@class='b132e4e12a']/ul/li"));
			for (WebElement suggestion : source_destinations) {
				System.out.println(suggestion.getText());
				if (suggestion.getText().contains("Kolkata")) { 
					suggestion.click();
					break;
				}
			}
			Thread.sleep(2000);
			WebElement checkindt = driver.findElement(By.xpath("//table//span[@class='cf06f772fa ef091eb985 f9bebc3246']"));
			checkindt.click();
			// WebElement adults  = driver.findElement(By.xpath("//table//span[@class='cf06f772fa ef091eb985 f9bebc3246']"));
			// adults.click();
			Thread.sleep(2000);
			//div[@class='d777d2b248']//button[@data-testid='occupancy-config']

			WebElement adultselect = driver.findElement(By.xpath("//div[@class='d777d2b248']//button[@data-testid='occupancy-config']"));
			adultselect.click();
			int i = 1;
			while(i<6) {
				WebElement adult_increment = driver.findElement(By.xpath("(//button[@class='a83ed08757 c21c56c305 f38b6daa18 d691166b09 ab98298258 bb803d8689 f4d78af12a'])[1]"));
				adult_increment.click();
				i++;
			}  
			WebElement done = driver.findElement(By.xpath("//button//span[@class='e4adce92df' and text()='Done']"));
			done.click();

			//button[@type='submit']/span[@class='e4adce92df' and text()='Search']
			WebElement search = driver.findElement(By.xpath("//button[@type='submit']/span[@class='e4adce92df' and text()='Search']"));
			search.click();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement Search_confirmation_text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='f6431b446c d5f78961c3']")));
			Search_confirmation_text.getText();
			if (!(Search_confirmation_text.getText().isEmpty())){
				System.out.println(Search_confirmation_text.getText()+" "+"Test Passed");
			}else {
				System.out.println("No records found");

			}
		}catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			// Close the browser
			driver.quit();
		}

	}
}


