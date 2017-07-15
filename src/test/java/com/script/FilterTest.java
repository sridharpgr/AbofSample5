package com.script;

import org.testng.annotations.Test;

import com.library.BaseClass;
import com.pages.FilterPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;

public class FilterTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	ProductPage productpage;
	FilterPage filterpage;
	
	@Test(priority=1, enabled=true)
	public void handleRadioButton() throws Exception {
		
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		productpage = new ProductPage(driver);
		filterpage = new FilterPage(driver);
		
		try{
			
			Thread.sleep(5000);
			loginpage.AbofCloseIcon.click();
			
			Thread.sleep(4000);
			homepage.abofOkGotIt.click();
			
			Thread.sleep(5000);
			homepage.abofMenTab.click();
			
			Thread.sleep(5000);
			homepage.noOfElements();
			homepage.abofNewInOption.get(1).click();
			homepage.abofClothingIcon.click();
			
			
			Thread.sleep(5000);
			productpage.abofFilterIcon.click();
			Thread.sleep(5000);
			filterpage.handleRadioButton();
			Thread.sleep(5000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
