package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CofigManager {//单例模式是指有且仅有一个实例
	//读取配置文件
	public static CofigManager cofigManager=null;
	public static Properties info=null;
	public CofigManager() {
		System.out.println("创建ConfigManager对象的无参构造......");
	  String configFile="jdbc.properties";
	  info=new Properties();
	  //通过Classpath获取资源，通过类所在的目录找资源文件
	  InputStream fis=CofigManager.class.getClassLoader().getResourceAsStream(configFile);
	    try {
			info.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//访问本类的一个全局访问点
	public static CofigManager getInstance(){
		if(cofigManager==null){
			cofigManager=new CofigManager();
		}
		return cofigManager;
	}

}
