package CoreJavaBasics;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class spicejethp {

	WebDriver driver;
	WebDriverWait wait ;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();


		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2); // 1 - Allow, 2 - Block, 0 - Default
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);


		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		WebElement from = driver.findElement(By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2' and text() = 'From']"));
		from.click(); 
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("kolkata");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Chennai");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).click();

		//div[@class="css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e" and text()='Passengers']
		//div[@data-testid="Adult-testID-plus-one-cta"]

		//div[@class="css-76zvg2 r-jwli3a r-ubezar r-1kfrs79" and text()='Done']

		Thread.sleep(2000);
		String adult = "5";
		driver.findElement(By.xpath("//div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e' and text()='Passengers']")).click();
		int i=1;
		while(i<5) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
			i++;


		}

		WebElement updated_adult = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1kz6sp'])[1]"));
		System.out.println(updated_adult.getText());
		//   Assert.assertEquals("adult count does not matches", adult,"Check 1: Values are not equal" );
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(updated_adult.getText(),adult,"Check 1: Values are not equal" );

		softAssert.assertAll();
		//Thread.sleep(2000);

		//	WebElement passengers = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh'])[3]"));
		//	WebElement done = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79' and text()='Done']"));
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79' and text()='Done']")));
		//WebDriverWait wait  = new WebDriverWait(driver,30);
		//driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79'])[1]"));
		//	Thread.sleep(4000);
		WebElement done = driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1kfrs79'])[1]"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", done);
		//js.executeScript("arguments[0].click();", done);
		//done.click();
		//Thread.sleep(4000);
		//done.click();



		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("window.scrollTo(0, document.body.scrollHeight);");


		//done.click();

		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa' and text()='Govt. Employee']")).click();
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1lgpqti']//div)[3]"));
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("arguments[0].scrollIntoView(true);", search);

		search.click();
		System.out.println("Successfully search the flight details"+ "Test Passed");

		//driver.close();

	}

}
