package dbconns;

import java.sql.*;

public class DBconn {
	private static String url = "jdbc:mysql://localhost:3306/reservations?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT"; 
	private static String username = "root"; 
	private static String password = "123456"; 
	private static Connection  conn = null;

	
	public static Connection init(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("-- success loading Mysql Driver --");
			conn = DriverManager.getConnection(url,username,password);
			return conn;
		} catch (Exception e) {
			System.out.println("!! sql init error !!");
			e.printStackTrace();
			return null;
		}
	}

	public static void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("!! sql close error !!");
			e.printStackTrace();
		}
	}
}
