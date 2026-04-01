package pages.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtil;

public class ProductsPage extends BasePage {

	By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
    By firstAddToCartBtn = By.cssSelector(".overlay-content a[data-product-id='1']");
    By viewProductBtn = By.xpath("(//a[contains(text(),'View Product')])[1]");
    By searchInput = By.id("search_product");
    By searchBtn = By.id("submit_search");
    By popup = By.id("cartModal");
    By viewCartBtn = By.xpath("//u[contains(text(),'View Cart')]");
    By continueShoppingBtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
    
    private By searchResults = By.cssSelector(".product-image-wrapper");
    private By searchedProducts = By.cssSelector(".productinfo p");
    private By getProductByName(String productName) 
    {
        return By.xpath("//div[@class='productinfo text-center']//p[contains(text(),'" 
                         + productName + "')]/ancestor::div[@class='product-image-wrapper']");
    }
    private By getAddToCartBtn(String productName) 
    {
        return By.xpath("//p[text()='" + productName + "']/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'Add to cart')]");
    }
    
    public boolean isSearchResultDisplayed() 
    {
        return isDisplayed(searchResults);
    }

    public ProductsPage(WebDriver driver) 
    {
        super(driver);
    }

    public void hoverAndAddFirstProduct() 
    {
        Actions actions = new Actions(driver);
        WebElement product = WaitUtil.waitForElement(firstProduct);
        actions.moveToElement(product).perform();
        WaitUtil.safeClick(firstAddToCartBtn);
    }

    public ProductDetailsPage clickViewProduct() 
    {
        click(viewProductBtn);
        return new ProductDetailsPage(driver);
    }

    public void searchProduct(String productName) 
    {
    	WaitUtil.removeAds();
    	WaitUtil.waitForElement(searchInput);
        type(searchInput, productName);
        click(searchBtn);
        WaitUtil.waitForElement(By.cssSelector(".product-image-wrapper"));
    }

    public void clickViewCartFromPopup() 
    {
    	WaitUtil.waitForElement(viewCartBtn);
    	WaitUtil.safeClick(viewCartBtn);
    }

    public void clickContinueShopping() 
    {
        click(continueShoppingBtn);
    }
    
    public void addProductToCart2(String productName) 
    {

        WebElement product = WaitUtil.waitForElement(getProductByName(productName));
        
        System.out.println("Trying to find product...");
        driver.findElements(By.xpath("//p")).forEach(e -> 
        System.out.println(e.getText())
        );

        ((JavascriptExecutor) driver)
            .executeScript("window.scrollBy(0, 500)");

        new Actions(driver).moveToElement(product).perform();
        WaitUtil.safeClick(getAddToCartBtn(productName));

    }
    
    public void addProductToCart(String productName) {

    	By addBtn = By.xpath(
    		    "//div[@class='productinfo text-center']//p[contains(text(),'" + productName + "')]" +
    		    "/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'Add to cart')]"
    		);
        ((JavascriptExecutor) driver)
            .executeScript("window.scrollBy(0, 300)");
        WaitUtil.safeClick(addBtn);
    }
    

    public boolean isSearchedProductDisplayed(String productName) {
        return driver.findElements(searchedProducts).stream().anyMatch(e -> e.getText().contains(productName));
    }
}
