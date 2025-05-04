package Souradipta.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Souradipta.AbstractClass.AbstractClass;

public class ProductCatalogue extends AbstractClass {
	WebDriver driver;

	// create a constructor to give life to this driver cause the main function
//	WebDriver driver = new ChromeDriver(); is on different class (in my case it is in SubmitOrderTest)
	public ProductCatalogue(WebDriver driver) {
		// this.driver is pointing to the above WebDriver driver but now we need to
		// point this
//		the driver in different page
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	We will write all the webElement as PageFactory

	@FindBy(xpath = "//div[contains(@class, 'mb-3')]")
	List<WebElement> productNames;

	public CartPage ProductNameByAddtoCart(String Product1, String Product2, String Product3) throws InterruptedException {

		waitUntilVisible(By.xpath("//div[contains(@class, 'mb-3')]"));

		String[] SelectProduct = { Product1, Product2, Product3 };

		for (String ProductName : SelectProduct) {
			// find products by product name
			WebElement products = productNames.stream()
					.filter(s -> s.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
					.orElse(null);

			if (products != null) {
				Thread.sleep(3000);
				products.findElement(By.xpath(".//button[last()]")).click();
			} else if (products == null) {
				System.out.println(ProductName + " Product not Found");
				Thread.sleep(3000);
				
			}
				
				
		}
		
		CartPage cartPage = new CartPage(driver);
		return cartPage;

	}

}