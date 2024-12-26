package Selenium_topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_actions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rsa-frontend-v1-g6ofl.ondigitalocean.app/create-a-project");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement firstmenu = driver.findElement(By.cssSelector("li.menu-item-has-children:nth-of-type(1)"));
		a.moveToElement(firstmenu).build().perform();
		driver.close();
	}

}
