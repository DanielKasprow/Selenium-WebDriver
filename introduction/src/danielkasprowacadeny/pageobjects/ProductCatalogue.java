package danielkasprowacadeny.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import danielkasprowacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="ng-animating3")
	WebElement spinner;
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By cart = By.cssSelector("[routerlink*='cart']");
	By totalRow = By.cssSelector(".totalRow button");
	By placeHolder = By.cssSelector("[placeholder='Select Country']");
	By taResults = By.cssSelector(".ta-results");
	By buttonTaItem = By.xpath("(//button[contains(@class,'ta-item')])[2]");
	By actionSubmit = By.cssSelector(".action__submit");
	By heroPrimary = By.cssSelector(".hero-primary");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDissappear(spinner);
	}
	
	public void cartOpenFinish(String productName) {
		driver.findElement(cart).click();
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(totalRow).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(placeHolder), "india").build().perform();
		waitForElementToAppear(taResults);
		driver.findElement(buttonTaItem).click();
		driver.findElement(actionSubmit).click();
		
		String confirmMessage = driver.findElement(heroPrimary).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
}
