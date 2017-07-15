package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	
	AndroidDriver driver = null;
	
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="com.abof.android:id/closeView")
	public WebElement AbofCloseIcon;
	
	@FindBy(id="com.abof.android:id/email_login_btn")
	public WebElement AbofYourEmailID;
	
	@FindBy(id="com.abof.android:id/login_email_edt")
	public WebElement AbofUserNameTextBox;
	
	@FindBy(id="com.abof.android:id/login_password_edt_edt")
	public WebElement AbofPasswordTextBox;
	
	
	@FindBy(id="com.abof.android:id/abof_login_btn")
	public WebElement AbofSignButton;
	
	@FindBy(name="Sign in")
	public WebElement AbofSignButtonText;
	
	
}
