package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransferPage extends BasePage {
	 
		public TransferPage(WebDriver driver) {
			super(driver);
		}

		//Using FindBy for locating elements
		@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_navigationSecondLevel\"]/ul/li/a[span/text()=\"Transfer to a Bank Account\"]") 
		private WebElement linkTransferToBankAccount;		
	 	
	 	// Defining all actions(Methods) that can be performed in the Profile page
	 		
		// This method is to click on Transfers Link
		public void clickOnTransferToBankAccount() {
			super.waitForCondition(ExpectedConditions.elementToBeClickable(linkTransferToBankAccount));
			linkTransferToBankAccount.click();
		} 
}
