package JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableSortingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /**********This Testcase verifies that the webtable sorting works as expected or not*********/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		//login check
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//tr/th[1]")).click();
		List <WebElement> elementlist =  driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originallist.equals(sortedlist));
		driver.close();
	}

}
