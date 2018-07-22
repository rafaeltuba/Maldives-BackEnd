package com.maldives.selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class UITest {
	
	static final String JDBC_DRIVER_MYSQL = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/maldives?characterEncoding=utf8";
	
	//  Database credentials
    static final String USER = "root";
    static final String PASSWORD = "#Rafatuba01";
    
    public static Connection getConnection() {
    	Connection conn = null;
        try {
           Class.forName(JDBC_DRIVER_MYSQL);
           conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch(SQLException se){
           se.printStackTrace();
        } catch(Exception e){
           e.printStackTrace();
        }
		return conn;
    }
    
    public void deleteAllEmpresas() throws SQLException {
		
		Connection connection = getConnection();
		try {
			String sql = "delete from empresa";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			System.out.println(statement);
		} finally {
			connection.close();
		}
	}
    
    public void deleteAllUsuarios() throws SQLException {
		
		Connection connection = getConnection();
		try {
			String sql = "delete from usuario";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			System.out.println(statement);
		} finally {
			connection.close();
		}
	}

}
