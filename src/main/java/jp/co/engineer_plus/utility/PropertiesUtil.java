package jp.co.engineer_plus.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static final Properties messageProperties = new Properties();
	static {
		try {
			messageProperties.load(PropertiesUtil.class.getResourceAsStream("/message.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getMessage(String key, String defaultValue) {
		return messageProperties.getProperty(key, defaultValue);
	}
	public static String getMessage(String key) {
		return messageProperties.getProperty(key);
	}
}
