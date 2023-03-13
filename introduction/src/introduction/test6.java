package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class test6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:/Users/trane/Desktop/selenium_kurs/chromedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]"));
		String checkboxText = checkbox.getText();
		checkbox.findElement(By.id("checkBoxOption3")).click();
		driver.findElement(By.id("dropdown-class-example"));
		
		WebElement select = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(select);
		dropdown.selectByVisibleText(checkboxText);
		driver.findElement(By.name("enter-name")).sendKeys(checkbox.getText());
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(checkboxText))
			System.out.println(true);
		else
			System.out.println(false);

	}

}
