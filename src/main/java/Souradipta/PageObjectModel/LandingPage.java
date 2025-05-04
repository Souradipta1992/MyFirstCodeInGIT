package Souradipta.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Souradipta.AbstractClass.AbstractClass;

public class LandingPage extends AbstractClass {
	WebDriver driver;
	//create a constructor to give life to this driver cause the main function
//	WebDriver driver = new ChromeDriver(); is on different class (in my case it is in SubmitOrderTest)
	public LandingPage(WebDriver driver) {
		//this.driver is pointing to the above WebDriver driver but now we need to point this 
//		the driver in different page
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	
	}
	
//	We will write all the webElement as PageFactory
	
	@FindBy (xpath="//input[@id='userEmail']")
	WebElement Username;
	@FindBy (xpath ="//input[@id='userPassword']")
	WebElement password;
	@FindBy (xpath ="//input[@id='login']")
	WebElement login;	
	@FindBy (xpath ="//*[contains(@class,'flyInOut')]")
	WebElement ErrorMessage;
	

	public ProductCatalogue loginIntoProduct(String UsernameString, String passwordString) {
	Username.sendKeys (UsernameString);
	password.sendKeys(passwordString);
	login.click();
	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	return productCatalogue;
	
	}

	public void GoTo(String URL) {
		driver.get(URL);
	}
	
	public void LoginErrorValidation() {
		
	waitForElement(ErrorMessage);
	ValidateErrorMessage(ErrorMessage, "Incorrect email or password.");
		}
}
