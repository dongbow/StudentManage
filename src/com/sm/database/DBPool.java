package com.sm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBPool {
	
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	
	static {
		ResourceBundle rb=ResourceBundle.getBundle("jdbc");
		DRIVER = rb.getString("jdbc.driver");
		URL = rb.getString("jdbc.url");
		USERNAME = rb.getString("jdbc.username");
		PASSWORD = rb.getString("jdbc.password");
	}
	
	public static Connection createConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Statement createStatement(Connection connection) {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	
	public static ResultSet executeQuery(Statement statement, String sql) {
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static int executeUpdate(Statement statement, String sql) {
		int row = 0;
		try {
			row = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		try {  
            connection.close();  
            statement.close(); 
            if(resultSet != null){
            	resultSet.close();
            }
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
	}
	
}
