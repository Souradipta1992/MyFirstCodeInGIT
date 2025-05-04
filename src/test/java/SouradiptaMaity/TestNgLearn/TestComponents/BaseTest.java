package SouradiptaMaity.TestNgLearn.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Souradipta.PageObjectModel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {

		Properties property = new Properties();
		FileInputStream path = new FileInputStream(
				"X:\\SeleniumAssignment\\TestNg\\src\\main\\java\\Souradipta\\Resources\\GlobalData.properties");
		property.load(path);

		String browser = property.getProperty("browser");

		if (browser.equalsIgnoreCase("Chrome")) {

			ChromeOptions Options = new ChromeOptions();
			Options.setAcceptInsecureCerts(true); // to accept the certificates
			// Launch Chrome
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(Options);
			
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public LandingPage launchApllicaton() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.GoTo("https://rahulshettyacademy.com/client/");
		return landingPage;
	}
	
	@AfterMethod	
	public void DriverClose() {
		driver.quit();
		
	}
	
	public String getBase64Screenshot() {
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	// ✅ Screenshot method (file-based)
    public String screenshot(String TestName) throws IOException {
        File scrsht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String FilePath = System.getProperty("user.dir") + "\\Reports\\" + TestName + ".png";
        File path = new File(FilePath);
        FileUtils.copyFile(scrsht, path);
        return FilePath;
    }

}
