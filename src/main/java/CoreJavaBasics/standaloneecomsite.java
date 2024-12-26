package CoreJavaBasics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standaloneecomsite {


	WebDriver driver;
	WebDriverWait wait ;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//login check
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		String prodname = "ZARA COAT 3";
		//cart functionality
		WebDriverWait wait = new WebDriverWait(driver,30);
		List <WebElement> cartproducts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'mb-3')]")));

		WebElement prod = cartproducts.stream().filter(product->product.findElement(By.xpath("//div[@class='card']//b")).getText().equalsIgnoreCase(prodname)).findFirst().orElse(null);     
		// finding product name from list of webelement and matches the string.
		prod.findElement(By.xpath("//button[@class='btn w-10 rounded' and text()=' Add To Cart']")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container"))); //success message after adding product to cart
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); //loader element
		WebElement cart = driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]"));
		cart.click(); 

		//button[@class='btn btn-primary' and text()='Checkout']
		WebElement checkout = driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Checkout']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary' and text()='Checkout']")));
		checkout.click();
		//button[contains(@class,'ta-item')])[2]
		WebElement country = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));		
		Actions a = new Actions(driver);
		a.sendKeys(country,"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0, 500);");
		//By.xpath("(//button[contains(@class,'ta-item')])[2]")));
		Thread.sleep(2000);
		WebElement place_order = driver.findElement(By.cssSelector(".action__submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		for (int i = 0; i < 3; i++) {  // Scroll 10 times
			js.executeScript("arguments[0].scrollIntoView(true);", place_order);
		    Thread.sleep(500);  // Pause to allow loading
		}
		place_order.click();
		String confirm_msg = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		Assert.assertTrue(confirm_msg.equalsIgnoreCase("Thankyou for the order."));
		System.out.println("Test Passed");
		driver.close();



	}

}
