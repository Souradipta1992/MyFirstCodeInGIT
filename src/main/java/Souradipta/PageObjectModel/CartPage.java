package Souradipta.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Souradipta.AbstractClass.AbstractClass;

public class CartPage extends AbstractClass{
	WebDriver driver;

	// create a constructor to give life to this driver cause the main function
//	WebDriver driver = new ChromeDriver(); is on different class (in my case it is in SubmitOrderTest)
	public CartPage(WebDriver driver) {
		// this.driver is pointing to the above WebDriver driver but now we need to
		// point this
//		the driver in different page
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement CartHeader;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement Checkout;
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement SelectCountry;
	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']//button")
	List<WebElement> countryList;
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement PlaceOrderButton;

	public void clickOnCart() {
		CartHeader.click();
	}

	public void checkOut() throws InterruptedException {
		
		waitUntilVisible(By.xpath("//button[text()='Checkout']"));
		clickWithMouseHoover(Checkout);
	}

	public void enterCountry(String country) {
		waitUntilVisible(By.xpath("//input[@placeholder='Select Country']"));
		SelectCountry.sendKeys(country);
	}

	public void selectCountry() {
		WebElement countryname = countryList.stream()
				.filter(country -> country.findElement(By.xpath(".//span")).getText().equals("India")).findFirst()
				.orElse(null);
		System.out.println("Country Selected as " + countryname.getText());
		countryname.click();

	}

	public void placeOrderAndConfirm() {
		PlaceOrderButton.click();
		WebElement ThankYouMessage = driver.findElement(By.xpath("//td/h1"));
		String Message = ThankYouMessage.getText();

		Assert.assertEquals(Message.equalsIgnoreCase("Thankyou for the order."), true);
	
	}

}
