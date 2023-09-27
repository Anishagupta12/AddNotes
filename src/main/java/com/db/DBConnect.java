package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
			public static Connection conn;
			public static Connection getConn()
			{
			   try {
					if(conn==null)
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
					    conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##anisha","anisha");
						
					}
								   
			   }catch(Exception e) {
				   e.printStackTrace();
			   }
				
				return conn;
			}
			
}
