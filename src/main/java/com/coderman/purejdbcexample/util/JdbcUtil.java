package com.coderman.purejdbcexample.util;


import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	private static final Properties settings = new Properties();
	private static final String fileName = "/Users/coderman/Desktop/SpringProjects/SpringData/src/main/java/com/coderman/PureJDBCExample/resources/jdbc.properties";

	private static final String url;
	private static String ip;
	private static String port;
	private static final String username;
	private static final String password;
	private static final String driver;
	
	private static final BasicDataSource basicDataSource;

	static {
		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			System.out.println("File is not found: " + fileName);
			e1.printStackTrace();
		}
		try {
			settings.load(in);
		} catch (IOException e) {
			System.out.println("Problem with IO: " + e.getMessage());
			e.printStackTrace();
		}

//		Use this line to list all loaded properties.
//		 settings.list(System.out);

		url = settings.getProperty("url");
		username = settings.getProperty("username");
		password = settings.getProperty("password");
		driver = settings.getProperty("driver");
		
		listProperties();
		
		// Create a data source
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
	}

//	public static Connection getConnection() {
//		Connection connection = null;
//		try {
//			Class.forName(driver);
//			connection = DriverManager.getConnection(url, username, password);
//		} catch (ClassNotFoundException e) {
//			System.out.println(driver + " is not found: " + e.getMessage());
//			e.printStackTrace();
//		} catch (SQLException e) {
//			System.out.println("In JDBCUtil, problem with getting a connection: " + e.getMessage());
//			e.printStackTrace();
//		}
//		return connection;
//	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = basicDataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("In JDBCUtil, problem with getting a connection: " + e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

	public static void listProperties() {
		System.err.format("\n******************************************************************************\n");
		System.err.format("* %50s %25s \n", "Creating the connection with following properties", "*");
		System.err.format("* %-20s %-50s %4s \n", "URL:", url, "*");
		System.err.format("* %-20s %-50s %4s \n", "Username:", username, "*");
		System.err.format("* %-20s %-50s %4s \n", "Password:", password, "*");
		System.err.format("* %-20s %-50s %4s \n", "Driver:", driver, "*");
		System.err.format("******************************************************************************\n");
		System.out.println();
	}
}
