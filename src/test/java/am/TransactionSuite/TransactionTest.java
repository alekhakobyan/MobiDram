package am.TransactionSuite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.CashOutPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.TransferPage;
import tests.BaseTest;
import tests.DataProviderClass;
import tests.TestData;

public class TransactionTest extends BaseTest {
	
	@Test(priority=0, dataProvider = "getData", dataProviderClass = DataProviderClass.class)
    public void Login_TC(TestData data) {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.setUserName(data.getUsername());
		loginPage.setPassword(data.getPassword());
		loginPage.clickOnLoginButton();
		
		ProfilePage profilePage = new ProfilePage(getDriver());
		assertTrue(profilePage.isUserLoggedIn(), "User is not logged in");
		profilePage.clickOnTransfersLink();
    }
	
	@Test(priority=1, invocationCount = 1,  dependsOnMethods={"Login_TC"}, dataProvider = "getData", dataProviderClass = DataProviderClass.class)
    public void Transaction_TC(TestData data) throws InterruptedException {
		System.out.println("Transfer To Bank Account:" + data.getTransferAmount());
		
		TransferPage transferPage = new TransferPage(getDriver());
		transferPage.clickOnTransferToBankAccount();
		
		CashOutPage cashOutPage = new CashOutPage(getDriver());
		cashOutPage.selectBankAccount(data.getBankAccount());
		cashOutPage.setTransferAmount(data.getTransferAmount());
		cashOutPage.selectPayment(data.getPayment());
		cashOutPage.clickOnCalculateButton();
		cashOutPage.setPin(data.getPin());
		cashOutPage.clickOnConfirmButton();
		//cashOutPage.clickOnYesButton();
		
		//Sleep
		cashOutPage.timeOut();
    }
}
