package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.loginPage;


public class TC_004_login extends TC_003_usedCars{
	loginPage lp;
	
	@Test(priority=7, groups =  {"sanity"})
	public void login() throws IOException {
		lp = new loginPage(driver);
		lp.clickLogin();
		String email = p.getProperty("email");
		lp.verifyEmail(email);
		logger.info("Login with invaild email id.....");
	}

}
