package popUP;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class windowPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
	}

}
