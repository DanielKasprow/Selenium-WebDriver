package testComponent.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponent.TestComponents.BaseTest;
import testComponent.pageobjects.CartPage;
import testComponent.pageobjects.CheckoutPage;
import testComponent.pageobjects.ConfirmationPage;
import testComponent.pageobjects.OrdersPage;
import testComponent.pageobjects.ProductCatalogue;



public class SubmitOrderTest extends BaseTest {
	
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
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"/src/testComponent/data/PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}
}
