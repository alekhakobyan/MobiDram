package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
 
public class HomePage extends BasePage {
 
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//Using FindBy for locating elements
 	@FindBy(how=How.XPATH, using="//*[@id=\"cphMaster_T362ED367001_Col00\"]/div[2]/a")
 	private WebElement entry;
 		
 	// Defining all actions(Methods) that can be performed in the Home page
 
 	// This method to click on 
 	public void clickOnEntry() {
		super.waitForCondition(ExpectedConditions.elementToBeClickable(entry));
		entry.click();
 	}
}
