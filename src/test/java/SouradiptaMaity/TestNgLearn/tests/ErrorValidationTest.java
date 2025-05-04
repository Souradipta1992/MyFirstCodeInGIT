package SouradiptaMaity.TestNgLearn.tests;

import org.testng.annotations.Test;

import Souradipta.PageObjectModel.ProductCatalogue;
import SouradiptaMaity.TestNgLearn.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {
	
	@Test
	public void LoginErrorValidatde() {

//		CartPage cartPage = new CartPage(driver);

		// Login to URL
		ProductCatalogue productCatalogue = landingPage.loginIntoProduct("souradiptaus@gmail.com", "Password1!");
		landingPage.LoginErrorValidation();
		
		
	}
}
