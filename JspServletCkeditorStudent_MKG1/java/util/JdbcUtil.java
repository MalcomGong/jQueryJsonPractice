package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
  private static String url;
  private static String user;
  private static String password;
  private static String driverClass;
/*  
  static{
	//从文件读取输入流
	  InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
	  //创建Properties对象
	  Properties pt = new Properties();
	  try {
		//从流读取数据到对�?
		pt.load(is);
		url = pt.getProperty("url");
		user = pt.getProperty("user");
		password = pt.getProperty("password");
		driverClass = pt.getProperty("driverClass");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
  }
  */
  
  //数据库连接方�?
public static Connection getConnection(){
	Connection conn = null;
	Properties info = CofigManager.getInstance().info;
	try {
		//1.利用反射机制加载数据库驱动?
		Class.forName(info.getProperty("driverClass"));
		try {
			//2.使用驱动管理器类获取数据库的连接对象
			conn = DriverManager.getConnection(info.getProperty("url"),info.getProperty("user"),info.getProperty("password"));
			System.out.println("数据库已连接...............................");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
	
}


//数据库连接关闭方�?
public static void closeConnection(Connection conn){
	if(conn!=null){
		try {
			conn.close();
			System.out.println("数据库已关闭................................");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
}
