package Selenium_topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_handling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		WebElement frme = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frme);
		Actions a = new Actions(driver);
		WebElement firsttab = driver.findElement(By.id("draggable"));
		WebElement secondtab = driver.findElement(By.id("droppable"));
		a.dragAndDrop(firsttab, secondtab).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@href='/resources/demos/droppable/accepted-elements.html']")).click();

	}

}
