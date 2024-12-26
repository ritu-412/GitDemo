package Selenium_topics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement openwindow = driver.findElement(By.xpath("//button[@id='openwindow']"));
		openwindow.click();
		String mainwindow = driver.getWindowHandle();
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		String Parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);

		WebElement emailtext = driver.findElement(By.xpath("(//div[@class='cont']/span)[1]"));
		
		System.out.println(emailtext.getText());
		String email = emailtext.getText();
		driver.switchTo().window(Parentwindow);
	    Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys(email);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();



		//driver.close();

	}
}

