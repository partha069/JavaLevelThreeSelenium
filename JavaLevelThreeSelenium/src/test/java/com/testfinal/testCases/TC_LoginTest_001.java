package com.testfinal.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testfinal.pageObject.LogOutPage;
import com.testfinal.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void TestCase_002() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		LogOutPage lo = new LogOutPage(driver);
		lp.setUserName(userName);
		logger.info("Click on Hello Signin Button");
		lp.clickonUserNextButton();
		logger.info("Enter UserName");
		lp.setPassword(password);
		logger.info("Enter Password");
		lp.clickonPassNextButton();
		logger.info("LoginButton");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.getTitle().equals("Inbox - partha.dey@qapitol.com - QAPITOL QA SERVICES PRIVATE LIMITED Mail")) {
			Assert.assertTrue(true);
		} else {
			captureScreenshots(driver, "LoginFail");
			Assert.assertTrue(false);
			logger.info("Failure");
		}
		Thread.sleep(2000);
		lo.clickOnAvatarIcon();
		lo.clickonLogoutbutton();
	}

	public void TestCase_001() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.clickonUserNextButton();
		logger.info("Next Buton");

		lp.validateErrorMessageForUserNameField();
		logger.info("Error Message for User Name");

	}

}
