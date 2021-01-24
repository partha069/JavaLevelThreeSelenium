package com.testfinal.testCases;

import org.testng.annotations.Test;
import com.testfinal.pageObject.LoginPage;

public class TC_LoginTest_002 extends BaseClass {
	
	@Test
	public void TestCase_001() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(userName);
		logger.info("Click on Hello Signin Button");

		lp.clickonUserNextButton();
		logger.info("Enter UserName");

		Thread.sleep(2000);
		
		lp.clickonPassNextButton();
		logger.info("LoginButton");

		lp.validateErrorMessageForPasswordField();
		logger.info("Error Message for Password");

	}
}
