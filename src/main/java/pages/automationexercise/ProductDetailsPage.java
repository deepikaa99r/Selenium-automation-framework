package pages.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtil;

public class ProductDetailsPage extends BasePage {

	private By addToCartBtn = By.cssSelector("button.btn.btn-default.cart");
    private By viewCartBtn = By.xpath("//u[contains(text(),'View Cart')]");

    public ProductDetailsPage(WebDriver driver) 
    {
        super(driver);
    }

    public void addToCart() 
    {

    	    WebElement btn = WaitUtil.waitForElement(addToCartBtn);
    	    ((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView(true);", btn);
    	    
    	    WaitUtil.safeClick(addToCartBtn);
    }

    public void goToCart() 
    {
        click(viewCartBtn);
    }
}