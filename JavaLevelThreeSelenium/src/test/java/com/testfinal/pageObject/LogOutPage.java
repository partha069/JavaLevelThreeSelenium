package com.testfinal.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

	WebDriver ldriver;

	public LogOutPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//img[@class='gb_Da gbii']")
	WebElement _avatarIcon;
	
	@FindBy(xpath = "//div[@class='gb_1f gb_Cb']/a[text()='Sign out']")
	WebElement _signout;
	

	public void clickOnAvatarIcon() {
		_avatarIcon.click();	
	}

	public void clickonLogoutbutton() {
		_signout.click();
	}
	
	
}
