package Selenium_topics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_handle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)"); //window scroll
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop = 5000");
		List <WebElement> amount = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum = 0;
		for(int i = 0;i< amount.size();i++) {
			String each_amt = amount.get(i).getText();
			int fin_amt = Integer.parseInt(each_amt);
			sum = sum + fin_amt;

		}
		int actualamt = sum ;
		String text = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		int Expectedamt = Integer.parseInt(text.split(":")[1].trim());
		Assert.assertEquals(actualamt, Expectedamt);

	}

}
