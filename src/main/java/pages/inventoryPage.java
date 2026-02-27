package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.HandleDropDownList;
import org.testng.Reporter;

public class inventoryPage extends TestBase {

	// create Object repository -

	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']")
	private WebElement productBackpack;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']")
	private WebElement productBikeLight;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement productBoltTShirt;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement productJacket;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']")
	private WebElement productOnesie;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']")
	private WebElement productRedtShirt;
	@FindBy(xpath = "//span[@class='title']")
	private WebElement pageTitle;
	@FindBy(xpath = "//a[text()='Twitter']")
	private WebElement twitterLogo;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement dropDwon;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private WebElement cartCount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartIcon;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-bolt-t-shirt']")
	private WebElement removeProdBoltTShirt;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-fleece-jacket']")
	private WebElement removePprodJacket;

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement topLeftMenuBtn;
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")
	private WebElement allItemsLinkTxt;
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	private WebElement aboutLinkTxt;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	private WebElement logOutLinkTxt;
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")
	private WebElement restLinkText;

	@FindBy(xpath = "//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']")
	private WebElement product1paraText;
	@FindBy(xpath = "//div[normalize-space(.)='$29.99']")
	private WebElement product1price;
	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	private WebElement product1AddToCartBtn;
	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	private WebElement product1AppToCartBtnTxt;

	public inventoryPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() {
		return pageTitle.getText();

	}

	public void clickOnCart() {
		cartIcon.click();
	}

	/*
	 * public String addProductToCart() throws InterruptedException {
	 * 
	 * // Select sc = new Select(dropdown);
	 * // sc.selectByVisibleText("Name (A to Z)");
	 * 
	 * HandleDropDownList.hndleSelect(dropdown, "Name (A to Z)");
	 * 
	 * backpackProduct.click();
	 * bikeLightProduct.click();
	 * boltTshirt.click();
	 * //labsOnsie.click();
	 * //fleeceJacket.click();
	 * // redTshirt.click();
	 * // bikeLightProduct.click();
	 * return cartCount.getText();
	 * 
	 * }
	 */

	public String add6Products() throws InterruptedException {
		HandleDropDownList.hndleSelect(dropDwon, "Price (low to high)");
		Thread.sleep(2000);
		productBackpack.click();
		productBikeLight.click();
		productBoltTShirt.click();
		productJacket.click();
		productOnesie.click();
		productRedtShirt.click();
		return cartIcon.getText();
	}

	public String remove2Products() throws InterruptedException {
		add6Products();// calling add method
		Thread.sleep(2000);
		removePprodJacket.click();
		removeProdBoltTShirt.click();
		return cartCount.getText();
	}

	public void printAllProductDetails() throws InterruptedException {
		Thread.sleep(2000); // Give the product grid time to load completely

		List<WebElement> productNamesList = driver
				.findElements(org.openqa.selenium.By.xpath("//div[@class='inventory_item_name']"));
		List<WebElement> productDescriptionsList = driver
				.findElements(org.openqa.selenium.By.xpath("//div[@class='inventory_item_desc']"));
		List<WebElement> productPricesList = driver
				.findElements(org.openqa.selenium.By.xpath("//div[@class='inventory_item_price']"));

		int totalProducts = productNamesList.size();
		Reporter.log("--- All Products Details ---<br>");
		Reporter.log("Number of products found: " + totalProducts + "<br>");

		for (int i = 0; i < totalProducts; i++) {
			String name = productNamesList.get(i).getText();
			String desc = productDescriptionsList.get(i).getText();
			String price = productPricesList.get(i).getText();

			// Using Reporter.log with <br> to format it on the HTML report
			Reporter.log("Product Name: " + name + "<br>");
			Reporter.log("Description : " + desc + "<br>");
			Reporter.log("Price       : " + price + "<br>");
			Reporter.log("--------------------------------------------------<br>");
			System.out.println("Product Name: " + name);
		}
	}

}
