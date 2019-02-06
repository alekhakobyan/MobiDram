package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
	 
		public LoginPage(WebDriver driver) {
			super(driver);
		}

		//Using FindBy for locating elements
		@FindBy(how=How.XPATH, using="//*[@type='text'][@name='ctl00$DefaultContent$txtUserName']") 
		private WebElement userNameTextBox;
		@FindBy(how=How.XPATH, using="//*[@type='password'][@name='ctl00$DefaultContent$txtPassword']") 
		private WebElement passwordTextBox;
		@FindBy(how=How.XPATH, using="//*[@type='button'][@id='ctl00_DefaultContent_rbtLogin_input']") 
		private WebElement signinButton;
	 		
	 	// Defining all actions(Methods) that can be performed in the Login page
	 
		 // This method is to set user name in the user name text box
		 public void setUserName(String strUserName) {
			 super.waitForCondition(ExpectedConditions.visibilityOf(userNameTextBox));
			 userNameTextBox.sendKeys(strUserName);
		 }
		 
		 // This method is to set Password in the password text box
		 public void setPassword(String strPassword) {
			 super.waitForCondition(ExpectedConditions.visibilityOf(passwordTextBox));
			 passwordTextBox.sendKeys(strPassword);
		 }
		 
		 // This method is to click on Login Button
		 public void clickOnLoginButton() {
			 super.waitForCondition(ExpectedConditions.elementToBeClickable(signinButton));
			 signinButton.click();
		 } 
	}
