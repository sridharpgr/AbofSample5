package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="com.abof.android:id/landing_okay_gt_it_btn")
	public WebElement abofOkGotIt;
	
	@FindBy(name="MEN")
	public WebElement abofMenTab;
	
	@FindBy(id="com.abof.android:id/img")
	public List<WebElement> abofNewInOption;
	
	public void noOfElements() {
		System.out.println(abofNewInOption.size());
	}

	@FindBy(name="Clothing")
	public WebElement abofClothingIcon;
	
	@FindBy(id="com.abof.android:id/badge_count")
	public WebElement abofBagCount;
	
	@FindBy(id="com.abof.android:id/actionbarbadge")
	public WebElement abofBagIcon;
	
	
	
}
