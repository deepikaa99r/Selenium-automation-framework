package pages.automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By productName = By.cssSelector(".cart_description h4 a");
    private By removeBtn = By.cssSelector(".cart_quantity_delete");
    private By emptyCartMsg = By.xpath("//*[contains(text(),'Cart is empty')]");
    private By productPrice = By.cssSelector(".cart_price p");
    private By productQuantity = By.cssSelector(".cart_quantity button");

    public CartPage(WebDriver driver) 
    {
        super(driver);
    }

    public boolean isProductDisplayed() 
    {
        return isDisplayed(productName);
    }

    public void removeProduct() 
    {
        click(removeBtn);
    }

    public boolean isCartEmpty() 
    {
        return isDisplayed(emptyCartMsg);
    }
    
    public String getProductName() 
    {
        return getText(productName);
    }

    public String getProductPrice() 
    {
        return getText(productPrice);
    }

    public String getProductQuantity() 
    {
        return getText(productQuantity);
    }

}