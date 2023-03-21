package framework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import danielkasprowacadeny.TestComponents.BaseTest;
import danielkasprowacadeny.pageobjects.CartPage;
import danielkasprowacadeny.pageobjects.CheckoutPage;
import danielkasprowacadeny.pageobjects.ConfirmationPage;
import danielkasprowacadeny.pageobjects.LandingPage;
import danielkasprowacadeny.pageobjects.OrdersPage;
import danielkasprowacadeny.pageobjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {
	
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {

		// LandingPage landingPage = launchApplication();
		// WebDriver driver = new EdgeDriver();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// LandingPage landingPage = new LandingPage(driver);
		// landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));

		Assert.assertTrue(match);

		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {

		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		OrdersPage ordersPage = productCatalogue.goToOrderPage();
		ordersPage.VerifyOrderDisplay(productName);

	}

	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File( "C:\\Users\\trane\\Desktop\\selenium_kurs\\"+ testCaseName +"\\screenshoot.png");
		FileUtils.copyFile(source, file);
		
		return "C:\\Users\\trane\\Desktop\\selenium_kurs\\"+ testCaseName +"\\screenshoot.png";
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		/*HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "anshika@gmail.com");
		map.put("password", "Iamking@000");
		map.put("product", "ZARA COAT 3");
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "shetty@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("product", "ADIDAS ORIGINAL");*/
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"/src/danielkasprowacademy/data/PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}
}
