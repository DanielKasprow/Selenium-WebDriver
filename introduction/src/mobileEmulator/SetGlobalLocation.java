package mobileEmulator;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;

public class SetGlobalLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EdgeDriver driver = new EdgeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map coordinates = new HashMap();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(title);
		

	}

}
