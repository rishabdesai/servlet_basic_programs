package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButils {
	public static final String url = "jdbc:sqlite:C:/Users/d_ris/Documents/bookshop.db";

	public static Connection getSQLiteConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
		return DriverManager.getConnection(url);

	}

}
