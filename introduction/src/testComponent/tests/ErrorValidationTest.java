package testComponent.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import testComponent.TestComponents.BaseTest;
import testComponent.TestComponents.Retry;

import testComponent.pageobjects.CartPage;
import testComponent.pageobjects.ProductCatalogue;


public class ErrorValidationTest extends BaseTest {


	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)

	public void LoginErrorValidation() throws IOException, InterruptedException {


		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking000");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test
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
