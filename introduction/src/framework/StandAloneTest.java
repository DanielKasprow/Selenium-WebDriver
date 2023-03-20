package framework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

	@Test
	public void submitOrder() throws IOException {

		// LandingPage landingPage = launchApplication();
		// WebDriver driver = new EdgeDriver();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// LandingPage landingPage = new LandingPage(driver);
		// landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");

		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);

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

}
