package com.library;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.util.Properties;

public class GenericClass {
	
	public static String configprop = BaseClass.sDirPath+"\\config.properties";
	
	//read data from the config.properties
	
	public static String getdataproperties(String key) {
		
		String svalue = null;
		Properties properties = new Properties();
		
		try{
			
			FileInputStream file = new FileInputStream(configprop);
			properties.load(file);
			svalue = properties.getProperty(key);
			
		}catch(Exception e){
			
		}
		return svalue;
	}

	

}
