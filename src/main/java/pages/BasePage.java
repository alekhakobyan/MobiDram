package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import utils.Constant;


public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constant.TIMEOUT), this);
    }
    
    @SuppressWarnings("deprecation")
	public void waitForCondition(ExpectedCondition<?> pageLoadCondition) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Constant.TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(Constant.POLLING, TimeUnit.SECONDS).ignoring(Exception.class);
		wait.until(pageLoadCondition);
	}
    
    public boolean isElementPresent(By selector) {
  		try {
  			driver.findElement(selector);
  			return true;
  		}
  		catch (org.openqa.selenium.NoSuchElementException e) {
  			return false;
  		}
  	}
    
    public void timeOut() throws InterruptedException {
	    int randomInt = (int)(Math.random()*((Constant.MAX-Constant.MIN)+1))+Constant.MIN;
	    TimeUnit.SECONDS.sleep(randomInt);
	}
}