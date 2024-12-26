package Selenium_topics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_actions1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Thread.sleep(15000);
		Actions a = new Actions(driver);
		WebElement accountmenu = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		a.moveToElement(accountmenu).build().perform();
		//driver.close();

		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("mobile").doubleClick().build().perform();

		//Just move to element, type the text inside the input box into uppercase, select the value by double click of it.
	}

}
