package Selenium_topics;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeparateTab_handling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement Footer_section = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int linksize = Footer_section.findElements(By.tagName("a")).size();
		System.out.println(linksize);

		List <WebElement> links = Footer_section.findElements(By.tagName("a"));
		for (int i = 1; i< linksize; i++) {

			String clickonTab = Keys.chord(Keys.CONTROL,Keys.ENTER); // handle to click an url with ctrl+enter mechanism.

			links.get(i).sendKeys(clickonTab);
			Thread.sleep(2000);
		}
		String mainwindow = driver.getWindowHandle(); 
		Set <String> tabs = driver.getWindowHandles();
		Iterator <String> it = tabs.iterator();
		while (it.hasNext()) {

			driver.switchTo().window(it.next()); //return child window id only
			System.out.println(driver.getTitle());


		}
		driver.switchTo().window(mainwindow); // switch to main window.
		driver.close();

	}


}


