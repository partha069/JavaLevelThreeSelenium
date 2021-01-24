package com.testfinal.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@type='email']")
	WebElement _userName;
	
	@FindBy(xpath = "//div[@class='VfPpkd-RLmnJb']")
	WebElement _userNameNextButton;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement _password;

	@FindBy(xpath = "(//div[@class='VfPpkd-RLmnJb'])[1]")
	WebElement _passwordNextButton;
	
	@FindBy(xpath = "//div[text()='Use another account']")
	WebElement _anotherUser;
	
	@FindBy(xpath = "//div[@class='o6cuMc']")
	WebElement _errorMessageForUserNameField;
	
	@FindBy(xpath = "//span[text()='Enter a password']")
	WebElement _errorMessageForPasswordField;
	
	
	public void setUserName(String name) {
		_userName.sendKeys(name);
	}

	public void clickonUserNextButton() {
		_userNameNextButton.click();
	}

	public void setPassword(String pass) {
		_password.sendKeys(pass);
	}

	public void clickonPassNextButton() {
		_passwordNextButton.click();
	}
	
	public void clickAnotherUser() {
		_anotherUser.click();
	}
	
	public void validateErrorMessageForUserNameField() {
		String errorMsgUN=_errorMessageForUserNameField.getText();
		Assert.assertEquals(errorMsgUN,"Enter an email or phone number");
	}
	
	public void validateErrorMessageForPasswordField() {
		String errorMsgPW=_errorMessageForPasswordField.getText();
		Assert.assertEquals(errorMsgPW,"Enter a password");
	}
	
}
