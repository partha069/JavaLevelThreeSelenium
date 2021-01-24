package com.testfinal.testCases;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testfinal.pageObject.LogOutPage;
import com.testfinal.pageObject.LoginPage;
import com.testfinal.utilities.XLUtils;

public class TC_LoginTest_003 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginTest(String userName, String password) throws InterruptedException {

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

		Thread.sleep(200);
		lo.clickOnAvatarIcon();
		logger.info("Clicked on Avatar Icon");
		lo.clickonLogoutbutton();
		logger.info("Clicked on Logout Button");
		lp.clickAnotherUser();
		logger.info("Clicked on Another User");

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/testfinal/testData/testData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colount = XLUtils.getcellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colount];

		for (int i = 1; i < rownum; i++) {

			for (int j = 0; j < colount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "sheet1", i, j); // 1 , 0
			}
		}
		return logindata;
	}

}
