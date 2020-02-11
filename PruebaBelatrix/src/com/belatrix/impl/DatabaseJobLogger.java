package com.belatrix.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import com.belatrix.interfaces.IJobLogger;

public class DatabaseJobLogger implements IJobLogger {
	
	private Connection connection = null;
	private Properties connectionProps = null;
	private static Map dbParams;
	private String insertString = "insert into Log values(?, ?)";
	
	public DatabaseJobLogger() {
		
	}
	
	protected void connect() throws Exception {
		try {
			connectionProps = new Properties();
			connectionProps.put("user", dbParams.get("userName"));
			connectionProps.put("password", dbParams.get("password"));
			connection = DriverManager.getConnection("jdbc:" +
				dbParams.get("dbms") + "://" + dbParams.get("serverName")
				+ ":" + dbParams.get("portNumber") + "/",
				connectionProps);
		} catch (SQLException sqle) {
			throw new Exception(sqle.getMessage());
		}
	}

	protected void disconnect () throws Exception {
		try {
			
			connection.close(); 
		} catch (SQLException sqle) {
			throw new Exception(sqle.getMessage());
		}
	}

	@Override
	public void logError(String messageText) throws Exception {
		try {
			this.connect();
			PreparedStatement preparedStatement = connection.prepareStatement(insertString); 
			preparedStatement.setString(1, messageText);
			preparedStatement.setInt(2, 2);
			preparedStatement.execute();
			this.disconnect();
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
	@Override
	public void logWarning(String messageText) throws Exception {
		try {
			this.connect();
			PreparedStatement preparedStatement = connection.prepareStatement(insertString); 
			preparedStatement.setString(1, messageText);
			preparedStatement.setInt(2, 3);
			preparedStatement.execute();
			this.disconnect();
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
	@Override
	public void logMessage(String messageText) throws Exception {
		try {
			this.connect();
			PreparedStatement preparedStatement = connection.prepareStatement(insertString); 
			preparedStatement.setString(1, messageText);
			preparedStatement.setInt(2, 1);
			preparedStatement.execute();
			this.disconnect();
			
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
	
	

}
