package popUP;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String downloadPath = System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("prefs", options);
		
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("[class*='file_browse']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\trane\\Documents\\test.exe");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
		
		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("Download Now")));
		driver.findElement(By.cssSelector("Download Now")).click();
		File f = new File(downloadPath + "\\convert.zip");
		if(f.exists()) {
			System.out.println("File found");
			if(f.delete())
				System.out.println("file deleted");
		}

	}

}
