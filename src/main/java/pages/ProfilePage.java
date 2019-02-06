package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.Constant;

public class ProfilePage extends BasePage {
	 
		public ProfilePage(WebDriver driver) {
			super(driver);
		}

		//Using FindBy for locating elements
		@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_navigationFirstLevel\"]/ul/li/a[span/text()=\"Transfers\"]") 
		private WebElement linkTransfers;
	 		
		//Using By for locating locators
	 	public By btnLogOut = By.className("logout");
	 	
	 	// Defining all actions(Methods) that can be performed in the Profile page
	 	
	 	// This method is to check User Logged In
	 	public boolean isUserLoggedIn() {
	 		super.driver.manage().timeouts().implicitlyWait(Constant.TIMEOUT, TimeUnit.SECONDS);	
	 		return super.isElementPresent(btnLogOut);
	 	} 
	 		
		// This method is to click on Transfers Link
		public void clickOnTransfersLink() {
			super.waitForCondition(ExpectedConditions.elementToBeClickable(linkTransfers));
			linkTransfers.click();
		} 
	}
