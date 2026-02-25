package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.helpers.Reporter;

import base.TestBase;
import utility.HandleDropDownList;

public class inventoryPage extends TestBase {

	// create Object repository

	/*@FindBy(xpath = "//span[@class='title']")
	private WebElement PageTitle;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement dropdown;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private WebElement cartCount;

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement backpackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement boltTshirt;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement bikeLightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement fleeceJacket;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	private WebElement labsOnsie;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	private WebElement redTshirt;*/
	
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement productBackpack;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement productBoltTShirt;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productJacket;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-onesie']") private WebElement productOnesie;
	@FindBy(xpath="//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement productRedtShirt;
	@FindBy(xpath="//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDwon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//button[@name='remove-sauce-labs-bolt-t-shirt']") private WebElement removeProdBoltTShirt;
	@FindBy(xpath="//button[@name='remove-sauce-labs-fleece-jacket']") private WebElement removePprodJacket;

	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement topLeftMenuBtn;
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")private WebElement allItemsLinkTxt;
	@FindBy(xpath = "//a[@id='about_sidebar_link']")private WebElement aboutLinkTxt;
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")private WebElement logOutLinkTxt;
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")private WebElement restLinkText;

	public inventoryPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() {
		return pageTitle.getText();

	}

	/*public String addProductToCart() throws InterruptedException {

		// Select sc = new Select(dropdown);
		// sc.selectByVisibleText("Name (A to Z)");

		HandleDropDownList.hndleSelect(dropdown, "Name (A to Z)");
		
		backpackProduct.click();
		bikeLightProduct.click();
		boltTshirt.click();
		//labsOnsie.click();
		//fleeceJacket.click();
		// redTshirt.click();
        // bikeLightProduct.click();
        return cartCount.getText();

	}*/
	
	public String add6Products() throws InterruptedException
	{
		HandleDropDownList.hndleSelect(dropDwon,"Price (low to high)");
		Thread.sleep(2000);
		productBackpack.click();
		productBikeLight.click();
		productBoltTShirt.click();
		productJacket.click();
		productOnesie.click();
		productRedtShirt.click();
		return cartIcon.getText();
	}

	
	/*public String removeProduct() throws InterruptedException
	{
		add6Products();
		Thread.sleep(3000);
		productOnesie.click();
		productRedtShirt.click();
		Thread.sleep(3000);
		return cartCount.getText();
		
	}*/
	
	public String remove2Products() throws InterruptedException
	{
		add6Products();//calling add method
		Thread.sleep(2000);
		removePprodJacket.click();
		removeProdBoltTShirt.click();
		return cartCount.getText();
	}
	
	public void clickOnCart()
	{
		cartIcon.click();
	}
	
	
	
	public  void topLeftMenuLinkTexts()
	{
		
		topLeftMenuBtn.click();
		allItemsLinkTxt.getText();
		aboutLinkTxt.getText();
		logOutLinkTxt.getText();
		restLinkText.getText();
		
		allItemsLinkTxt.isEnabled();
		aboutLinkTxt.isEnabled();
		logOutLinkTxt.isEnabled();
		removePprodJacket.isEnabled();
		
	    
		
		
	}




}
