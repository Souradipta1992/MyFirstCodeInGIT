package SouradiptaMaity.TestNgLearn.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import Souradipta.PageObjectModel.CartPage;
import Souradipta.PageObjectModel.ProductCatalogue;
import SouradiptaMaity.TestNgLearn.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void SubmitOrder() throws InterruptedException, IOException {

		//TESTING GIT

		// Login to URL
		ProductCatalogue productCatalogue = landingPage.loginIntoProduct("souradiptaus@gmail.com", "Password1!");
		// Add to cart
		
		CartPage cartPage = productCatalogue.ProductNameByAddtoCart("ADIDAS ORIGINAL", "ZARA COAT 3", "Apple");
//		productCatalogue.screenshot();

//			Click on Cart And Checkout
		cartPage.clickOnCart();
		cartPage.checkOut();
		// Place Order
		cartPage.enterCountry("INDIA");
		Thread.sleep(1000);
		// Country List where two names present Select INDIA
		cartPage.selectCountry();
		cartPage.placeOrderAndConfirm();

	}
}
