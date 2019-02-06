package am.LoginSuite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProfilePage;
import tests.BaseTest;

public class LoginTest extends BaseTest {
	
	@Parameters({"username", "password"})
	@Test
    public void Login_TC(String uname, String pass) {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.setUserName(uname);
		loginPage.setPassword(pass);
		loginPage.clickOnLoginButton();
		
		ProfilePage profilePage = new ProfilePage(getDriver());
		assertTrue(profilePage.isUserLoggedIn(), "User is not logged in");
    }
}
