package com.freshie.site;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Config {
	
	private static final Logger logger = LoggerFactory
			.getLogger(Config.class);
	
	private static Properties PROPERTIES;
	
	//load properties
	static{
		PROPERTIES = new Properties();
		InputStream in = Config.class.getResourceAsStream("config.properties");
		try {
			PROPERTIES.load(in);
			in.close();
		} catch (Exception e) {
			logger.error("Error loading properties file!");
			e.printStackTrace();
		}
	}
	
	//return values
	public static String getValue(String key){
		return PROPERTIES.getProperty(key);		
	}
	
	public static int getInt(String key){
		return Integer.parseInt(PROPERTIES.getProperty(key));
	}

}
