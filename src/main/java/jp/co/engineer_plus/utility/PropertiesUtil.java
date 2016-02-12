package jp.co.engineer_plus.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static final Properties messages = new Properties();
	private static final Properties settings = new Properties();
	static {
		try {
			messages.load(PropertiesUtil.class.getResourceAsStream("/message.properties"));
			settings.load(PropertiesUtil.class.getResourceAsStream("/engineer_plus.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getMessage(String key, String defaultValue) {
		return messages.getProperty(key, defaultValue);
	}
	public static String getMessage(String key) {
		return messages.getProperty(key);
	}
	public static String getSetting(String key) {
		return settings.getProperty(key);
	}
	public static String getSetting(String key, String defaultValue) {
		return settings.getProperty(key, defaultValue);
	}
	public static Integer getSettingToInt(String key, Integer defaultValue) {
		try {
			return Integer.valueOf(settings.getProperty(key));
		} catch (Exception e) {
			return defaultValue;
		}
	}
}
