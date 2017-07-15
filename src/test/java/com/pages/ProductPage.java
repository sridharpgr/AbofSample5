package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ProductPage {
	
	AndroidDriver driver;
	
	public ProductPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="com.abof.android:id/img_filter")
	public WebElement abofFilterIcon;
	
	@FindBy(id="com.abof.android:id/txt_product_count")
	public WebElement abofNoOfProducts;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='0']//android.widget.ImageButton[@index='0']")
	public WebElement abofBackButton;
	
	@FindBy(id="com.abof.android:id/txtShoppingBagItem")
	public WebElement abofShoppingBagItemsHeading;
	
	@FindBy(id="com.abof.android:id/parent_layout")
	public List<WebElement> abofBagItemsList;

}
