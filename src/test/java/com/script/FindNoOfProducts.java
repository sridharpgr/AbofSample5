package com.script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.library.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;

public class FindNoOfProducts extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	ProductPage productpage;

	@Test(enabled=false)
	public void getNoOfProducts() throws Exception{
		
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		productpage = new ProductPage(driver);
		
		try{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			loginpage.AbofYourEmailID.click();
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			loginpage.AbofUserNameTextBox.sendKeys("abofqa.raghucbt@gmail.com");
			loginpage.AbofPasswordTextBox.sendKeys("raghukiran92");
			loginpage.AbofSignButton.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			homepage.abofOkGotIt.click();
			homepage.abofMenTab.click();
			homepage.abofNewInOption.get(1).click(); //click on NEW IN image
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			List <WebElement> listOfElements = driver.findElementsByXPath("//android.widget.RelativeLayout[@index='1']//android.widget.LinearLayout[@index='1']"); // get the list of elements under NewIn options
			System.out.println(listOfElements.size());
			
			//Get the list under NewIn Image
			for(int i=0; i<listOfElements.size(); i++) {
				
				String text = driver.findElementByXPath("//android.widget.RelativeLayout[@index='1']//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='"+i+"']//android.widget.TextView[@index='0']").getText();
				System.out.println(text);
				Thread.sleep(1000);
				
			}
			
			//Get the no of products under each option (like clothing --> no of products, footwear --> no of products
			
			int pcount=0;
			int ptotalcount=0;
			
			for(int i=0; i<listOfElements.size(); i++) {
				
				String text = driver.findElementByXPath("//android.widget.RelativeLayout[@index='1']//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='"+i+"']//android.widget.TextView[@index='0']").getText();
				System.out.println(text);
				
				if(!text.equals("View All")){
					
					driver.findElementByXPath("//android.widget.RelativeLayout[@index='1']//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='"+i+"']").click();
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					pcount = extractNumber(productpage.abofNoOfProducts.getText());
					pcount += pcount;
					productpage.abofBackButton.click();
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				}	
				else{
					driver.findElementByXPath("//android.widget.RelativeLayout[@index='1']//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='"+i+"']").click();
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					ptotalcount = extractNumber(productpage.abofNoOfProducts.getText());
					productpage.abofBackButton.click();
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				}
			}
			
			if(pcount == ptotalcount)
				System.out.println("Product total count is matched");
			else
				System.out.println("Product total count is not matched");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void getBagCount() throws Exception{
		
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		productpage = new ProductPage(driver);
		
		try{
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			loginpage.AbofYourEmailID.click();
			loginpage.AbofUserNameTextBox.sendKeys("abofqa.raghucbt@gmail.com");
			loginpage.AbofPasswordTextBox.sendKeys("raghukiran92");
			loginpage.AbofSignButton.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			homepage.abofOkGotIt.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Thread.sleep(3000);
			int bagcount = Integer.parseInt(homepage.abofBagCount.getText());
			System.out.println(bagcount);
			homepage.abofBagIcon.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			int bagcount1 = extractNumber(productpage.abofShoppingBagItemsHeading.getText());
			System.out.println(bagcount1);
			
			if(bagcount==bagcount1)
				System.out.println("BagItems count is matched with bagitemsheading count");
			else
				System.out.println("BagItems count is not matched with bagitemsheading count");
			
			int bagItemslistcount = productpage.abofBagItemsList.size();
			System.out.println("bagItemslistcount:"+bagItemslistcount);
			
			if(bagcount==bagItemslistcount)
				System.out.println("BagItems count is matched with bagitemslist count");
			else
				System.out.println("BagItems count is not matched with bagitemslist count");
			
//			driver.findElementByAndroidUIAutomator(using)
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
