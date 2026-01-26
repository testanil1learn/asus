package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = new Properties();
	
	static {
	
	try {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\annyk\\eclipse-workspace\\asus\\"
				+ "src\\main\\resources\\config.properties");
		prop.load(fis);
		
	} catch (Exception e) {
		throw new RuntimeException("Config File not found");
	}
	}
	
	 public static String get(String key) {
	        return prop.getProperty(key);
	    
	}

	
}
