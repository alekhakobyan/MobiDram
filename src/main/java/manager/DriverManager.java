package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.Os;

public class DriverManager {
	protected OS oS;
	
	public DriverManager() {
		if (Os.isMac()) { 
			this.oS = DriverManager.OS.MAC; 
		} else if (Os.isWindows()) { 
			this.oS = DriverManager.OS.WINDOWS; 
		}
	}
	
	public enum Browser {
		FIREFOX, CHROME, SAFARI
	};
	
	public enum OS {
		MAC, WINDOWS
	};
	
	public WebDriver startDriver(Browser browser) {
		WebDriver driver = null;
	
		switch (oS) {
			case WINDOWS:
				System.setProperty("webdriver.chrome.driver","resource/browserDriver/chromedriver.exe");
				break;	
			case MAC: 
				System.setProperty("webdriver.chrome.driver","resource/browserDriver/chromedriver");
				break;
		}
		
		switch(browser) {
			case CHROME:
				driver = new ChromeDriver(); 
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case SAFARI:
				driver = new SafariDriver();
				break;
		}
		return driver;
	}
}
