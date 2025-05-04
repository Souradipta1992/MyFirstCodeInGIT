package Souradipta.AbstractClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DurationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractClass {

	WebDriver driver;

	public AbstractClass(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilVisible(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, DurationUtils.toDuration(5, TimeUnit.SECONDS));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));

	}

	public void waitUntilInvisible(By FindBy) {

		WebDriverWait wait1 = new WebDriverWait(driver, DurationUtils.toDuration(5, TimeUnit.SECONDS));
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));

	}

	public void focusOnTheElement(WebElement webElement) {
		Actions action = new Actions(driver);
		action.moveToElement(webElement);

	}

	public void clickWithMouseHoover(WebElement webElement) {
		Actions action = new Actions(driver);
		action.moveToElement(webElement).pause(Duration.ofSeconds(2)).click().build().perform();

	}

	public void ValidateErrorMessage(WebElement Actual, String expectedText) {
		String element = Actual.getText();
		Assert.assertTrue(element.equalsIgnoreCase(expectedText), expectedText);
	}
	
	public void waitForElement(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	}
}
