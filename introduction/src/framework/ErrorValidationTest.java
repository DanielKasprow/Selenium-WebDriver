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
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import danielkasprowacadeny.TestComponents.BaseTest;
import danielkasprowacadeny.pageobjects.CartPage;
import danielkasprowacadeny.pageobjects.CheckoutPage;
import danielkasprowacadeny.pageobjects.ConfirmationPage;
import danielkasprowacadeny.pageobjects.LandingPage;
import danielkasprowacadeny.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest{

	@Test
	public void LoginErrorValidation()
	{
		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking000");
		AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test(groups= { "ErrorHanling"})
	public void ProductErrorValidation() throws IOException {
		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay("Zara Coat 33");
		Assert.assertFalse(match);
		
		
	}

}
