package tests.automationexercise;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.automationexercise.*;

public class CartTest extends BaseTest {

   @Test
    public void addToCartViaOverlay() {
	   
        doLogin("shelby99@gmail.com","n6fZUBLN8E875pIR");
        ProductsPage products = new HomePage(driver).goToProductsPage();
        products.hoverAndAddFirstProduct();
        products.clickViewCartFromPopup();
        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isProductDisplayed());
        cart.removeProduct();
    }

   @Test
    public void addToCartViaProductDetails() {
	   
    	doLogin("shelby99@gmail.com","n6fZUBLN8E875pIR");
        ProductsPage products = new HomePage(driver).goToProductsPage();
        ProductDetailsPage details = products.clickViewProduct();
        details.addToCart();
        details.goToCart();
        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isProductDisplayed());
        cart.removeProduct();
    }

   @Test
    public void searchAndAddProductToCart() {
	  
	    doLogin("shelby99@gmail.com","n6fZUBLN8E875pIR");
        ProductsPage products = new HomePage(driver).goToProductsPage(); 
        products.searchProduct("Lace Top");
        products.addProductToCart("Lace Top");
        products.clickViewCartFromPopup();
        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isProductDisplayed());
        cart.removeProduct();
    }

    @Test
    public void removeProductFromCart() {

    	doLogin("shelby99@gmail.com","n6fZUBLN8E875pIR");
        ProductsPage products = new HomePage(driver).goToProductsPage();
        products.hoverAndAddFirstProduct();
        products.clickViewCartFromPopup();
        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isProductDisplayed());
        cart.removeProduct();
        Assert.assertTrue(cart.isCartEmpty());
    }
    
    @Test
    public void verifyUserCanSearchAndAddProductToCart() {
 	
        HomePage home = doLogin("shelby99@gmail.com","n6fZUBLN8E875pIR");
        ProductsPage products = home.goToProductsPage();
        dismissPopup();  
        products.searchProduct("Lace Top");
        products.addProductToCart("Lace Top");
        products.clickViewCartFromPopup();
        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isProductDisplayed(), "Product is not displayed in cart");
        Assert.assertTrue(cart.getProductName().contains("Lace Top"),"Incorrect product added to cart");
        Assert.assertEquals(cart.getProductQuantity(),"1","Product quantity mismatch");
    }
}    

