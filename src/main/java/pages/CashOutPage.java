package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CashOutPage extends BasePage {
		public CashOutPage(WebDriver driver) {
			super(driver);
		}

		//Using FindBy for locating elements
		@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_DefaultContent_ddlBankAccounts_Arrow\"]") 
		private WebElement bankAccountArrow;
		@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_DefaultContent_ucBankTransferControl_ucPaymentMethod_cmbPaymentMethod_Arrow\"]") 
		private WebElement paymentArrow;
		@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_DefaultContent_ucBankTransferControl_ntbAmount\"]") 
		private WebElement transferAmount;
		@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_DefaultContent_ucBankTransferControl_rbtCalculate\"]") 
		private WebElement calculateButton;
		@FindBy(how=How.XPATH, using="//*[@type='password'][@name='ctl00$DefaultContent$ucBankTransferControl$txtPin']") 
		private WebElement pinTextBox;
		@FindBy(how=How.XPATH, using="//*[@id=\"ctl00_DefaultContent_ucBankTransferControl_rbtConfirm\"]") 
		private WebElement confirmButton;
		@FindBy(how=How.LINK_TEXT, using="Yes") 
		private WebElement yesButton;
		
	 	// Defining all actions(Methods) that can be performed in the Profile page
	 		
		// This method is Select on Bank Account 
		public void selectBankAccount(String bAccount) {
			super.waitForCondition(ExpectedConditions.elementToBeClickable(bankAccountArrow));
			// Click on Bank Account list
			bankAccountArrow.click();
			
			By bankAccount = By.xpath("//*[text() = '"+ bAccount +"']");
			WebElement bankAccountName = super.driver.findElement(bankAccount);
			super.waitForCondition(ExpectedConditions.textToBePresentInElement(bankAccountName, bAccount));
			bankAccountName.click();
		} 
		
		// This method is Enter Transfer Amont
		public void setTransferAmount(String tAmount) {
			super.waitForCondition(ExpectedConditions.visibilityOf(transferAmount));
			transferAmount.sendKeys(tAmount);
		} 
		
		// This method is Select Payment
		public void selectPayment(String pay) {
			super.waitForCondition(ExpectedConditions.elementToBeClickable(paymentArrow));
			// Click on Payment list
			paymentArrow.click();
		
			By card = By.xpath("//*[text() = '"+ pay +"']");
			WebElement payment = super.driver.findElement(card);
			super.waitForCondition(ExpectedConditions.textToBePresentInElement(payment, pay));
			payment.click();
		} 
		
		// This method is to click on Calculate Button
		public void clickOnCalculateButton() {
			super.waitForCondition(ExpectedConditions.elementToBeClickable(calculateButton));
			calculateButton.click();
		} 
		
		// This method is to set Pin
		public void setPin(String pin) {
			super.waitForCondition(ExpectedConditions.visibilityOf(pinTextBox));
			pinTextBox.sendKeys(pin);
		}
		
		// This method is to click on Confirm Button
		public void clickOnConfirmButton() {
			super.waitForCondition(ExpectedConditions.elementToBeClickable(confirmButton));
			confirmButton.click();
		} 
		
		// This method is to click on Yes Button
		public void clickOnYesButton() {
			super.waitForCondition(ExpectedConditions.elementToBeClickable(yesButton));
			yesButton.click();
		} 
}
