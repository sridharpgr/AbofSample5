package com.script;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.library.BaseClass;
import com.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test(dataProvider="getData", description="Log in to Abof Application")
	public void logintoAbofApplication(String username, String password) throws Exception {
		
		LoginPage loginpage = new LoginPage(driver);
		
		try{
			Thread.sleep(4000);
			loginpage.AbofYourEmailID.click();
			Thread.sleep(3000);
			Assert.assertTrue(loginpage.AbofUserNameTextBox.isDisplayed(),"The AbofUsername textbox is not displayed");
			NXGReports.addStep("the abofusername textbox is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			loginpage.AbofUserNameTextBox.sendKeys(username);
			handleKeyboard();
			Thread.sleep(4000);
			Assert.assertTrue(loginpage.AbofPasswordTextBox.isDisplayed(),"The Abofpassword textbox is not displayed");
			NXGReports.addStep("the abofpassword textbox is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			loginpage.AbofPasswordTextBox.sendKeys(password);
			Thread.sleep(4000);
			handleKeyboard();
			Thread.sleep(2000);
			Assert.assertTrue(loginpage.AbofSignButtonText.isDisplayed(),"The Abofsign in button is not displayed");
//			Assert.assertFalse(loginpage.AbofSignButtonText.isDisplayed(), "The Abofsign in button is not displayed");
			NXGReports.addStep("the abofSignButton is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			loginpage.AbofSignButtonText.click();	
		}catch(Exception e){
			throw e;
		}
	}
	
	@DataProvider
	public Object[][] getData() throws Exception {
		
		Object[][] data = new Object[2][2];
		data[0][0]="sfsdfds@gmail.com";
		data[0][1]="ertretgfg";
		
		data[1][0]="abofqa.raghucbt@gmail.com";
		data[1][1]="raghukiran92";
		
//		data[2][0]="abofqa.raghucbt@gmail.com";
//		data[2][1]="raghukiran92";
		
		return data;
		
	}
}