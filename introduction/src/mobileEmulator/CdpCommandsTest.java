package mobileEmulator;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;

public class CdpCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		EdgeDriver driver = new EdgeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map deviceMetrics = new HashMap();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 50);
		deviceMetrics.put("mobile", true);

		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Library")).click();

	}

}
