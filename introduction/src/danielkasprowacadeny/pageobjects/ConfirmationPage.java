package danielkasprowacadeny.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import danielkasprowacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	WebDriver driver;


	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By confirmationMessage = By.cssSelector(".hero-primary");
	
	public String getConfirmationMessage() {
		return driver.findElement(confirmationMessage).getText();
	}

}
