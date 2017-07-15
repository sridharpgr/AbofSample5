package com.library;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.kirwa.nxgreport.NXGReports;
import com.library.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseClass {
	
	public DesiredCapabilities capabilities;
	public static String sDirPath = System.getProperty("user.dir");
	public String apkFilePath = sDirPath+"\\ApkFile\\abof_com.abof.android.apk";
	
	public AndroidDriver driver;
	public static String node = "C:\\Program Files (x86)\\Appium\\node.exe";
	public static String appiumjs = "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js";
	public AppiumDriverLocalService server;
	
	@BeforeSuite
	public void startAppiumServer() {
		
		server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).usingDriverExecutable(new File(node)).withAppiumJS(new File(appiumjs)));
		server.start();
		
	}
	
	@BeforeTest
	public void setup(){
		
		try {
			
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", GenericClass.getdataproperties("AUTOMATIONNAME"));
			capabilities.setCapability("platformName", GenericClass.getdataproperties("PLATFORMNAME"));
			capabilities.setCapability("deviceName", GenericClass.getdataproperties("DEVICENAME"));
			capabilities.setCapability("platfromVersion", GenericClass.getdataproperties("PLATFORMVERSION"));
			capabilities.setCapability("app", apkFilePath);
			capabilities.setCapability("appPackage", GenericClass.getdataproperties("APPPACKAGE"));
			capabilities.setCapability("appActivity", GenericClass.getdataproperties("APPACTIVITY"));
			driver=new AndroidDriver(new URL(GenericClass.getdataproperties("APPIUMSERVERURL")), capabilities);
			NXGReports.setWebDriver(driver);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
	
	public void handleKeyboard() {
		try{
			driver.hideKeyboard();
		}catch(Exception e) {
			
		}
	}
	
	public int extractNumber(String pcountstr) {
		int pcountint= Integer.parseInt(pcountstr.replaceAll("[^0-9]", ""));
		System.out.println(pcountint);
		return pcountint;
		
	}
	
	@AfterSuite
	public void stopServer() {
		server.stop();
	}
	
	
}
