package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import manager.DriverManager;

public class BaseTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
    	DriverManager driverManager = new DriverManager();
		
		// To start driver
		driver = driverManager.startDriver(DriverManager.Browser.CHROME);
		
		//To maximize browser
		driver.manage().window().maximize();
		
		//To open page
		driver.get("https://login.mobidram.am");
    }

    @AfterClass
    public void afterClass() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
