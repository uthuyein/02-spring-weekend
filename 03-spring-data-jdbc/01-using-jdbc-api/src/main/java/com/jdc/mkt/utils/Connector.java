package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	private static final String URL = "jdbc:mysql://localhost:3306/testDb";
    private static final String user = "root";
    private static final String password = "admin";
//    private static Connector instance;
    
//    private Connector() {}
//    
//    public static Connector getInstance() {
//    	synchronized (instance) {
//    		if(null == instance) {
//        		instance = new Connector();
//        	}
//		}
//    		
//    	return instance;
//    }
    
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, user, password);
	}
}
