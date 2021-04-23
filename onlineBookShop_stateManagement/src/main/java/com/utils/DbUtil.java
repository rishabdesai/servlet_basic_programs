package com.utils;

import java.io.InputStream;
import java.util.Properties;

public class DbUtil {
	public static String DB_DRIVER = "";
	public static String DB_URL = "";
	public static String DB_USER = "";
	public static String DB_PASS = "";

	static Properties props;
	
	static {
		try (InputStream in = DbUtil.class.getResourceAsStream("/jdbc.properties")) {
			props = new Properties();
			props.load(in);
			DB_DRIVER = props.getProperty("db.driver");
			DB_URL = props.getProperty("db.url");
			DB_USER = props.getProperty("db.user");
			DB_PASS = props.getProperty("db.password");

			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
