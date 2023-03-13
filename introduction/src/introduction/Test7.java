package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement table = driver.findElement(By.cssSelector("table[name='courses']"));
		
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		System.out.println(table.findElements(By.tagName("tr")).size());
		
		List<WebElement> values = driver.findElements(By.cssSelector("div[class='left-align'] tr:nth-child(3)"));
		
		for(int i = 0; i<values.size(); i++)
		{
			System.out.println(values.get(i).getText());
		}
		


	}

}
