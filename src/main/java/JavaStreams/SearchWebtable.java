package JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchWebtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*******This testcase to check if the webtable contains the same search item which has given in the
		 searchbox to search *******/
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		//login check
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List <WebElement> elementlist = driver.findElements(By.xpath("//tr/td[1]"));
		List <WebElement> filterlist =  elementlist.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(elementlist.size(), filterlist.size());
	}

}
