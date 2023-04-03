package testComponent.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponent.TestComponents.BaseTest;
import testComponent.pageobjects.CartPage;
import testComponent.pageobjects.CheckoutPage;
import testComponent.pageobjects.ConfirmationPage;
import testComponent.pageobjects.LandingPage;
import testComponent.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {

	public LandingPage landingPage;
	ProductCatalogue productCatalogue;
	ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);

	}

	@When("^I add product (.+) from Cart$")
	public void i_add_product_to_cart(String product) {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(product);

	}

	@And("^Checkout (.+) and submit the order$")
	public void checkout__submit_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);

		Assert.assertTrue(match);

		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string) {
		String confirmMessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.quit();

	}
	
	@Then("{string} message is displayed")
	public void something_message_is_displayed(String string) throws Throwable{
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.quit();

	}
}
