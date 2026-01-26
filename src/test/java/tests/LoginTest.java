package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basefiles.BaseTest;
import driverfactory.DriverFactory;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	
	
	@Test (priority=1)
	public void verifyLogin() {
		
		LoginPage loginpage = new LoginPage();
		
		loginpage.login("user", "pass");
		
		Assert.assertTrue(true);
		
	}
	
	
	
}
