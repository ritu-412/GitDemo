package JavaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtablepagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
		//login check
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List <WebElement> elementlist =  driver.findElements(By.xpath("//tr/td[1]"));
		List<String> filterlist  = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		//fetch the total list after clicking on the column
		List<String> sortedlist = filterlist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(filterlist.equals(sortedlist));
		List<String> price;
		
		do
		{
		List<WebElement>rows = driver.findElements(By.xpath("//tr/td[1]"));	
		price = rows.stream().filter(s->s.getText().equals("Rice")).map(s->getveggiesprice(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));	
		if(price.size()<1){
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
			
		
		
			
	}	
		
	
	
	public static String getveggiesprice(WebElement a) {
		
		String pricevalue = a.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
		
	}

}


