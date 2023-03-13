package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selinintroduction{

	public static void main(String[] args) {
		
		//Invoking Browser
		//CHrome - ChromeDriver ->Methods
		//Firefox - FirefoxDriver ->Methods
		//safari SaariDriver ->methods
		//WebDriver merhods + class methods
		
		// chromedriver.exe-> Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:/Users/trane/Desktop/selenium_kurs/chromedriver.exe");
		
		//webdriver.chrome.driver-> value of path
		WebDriver driver = new ChromeDriver();
		driver.get("https://streamable.com/2ilxxs");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
	}

}
