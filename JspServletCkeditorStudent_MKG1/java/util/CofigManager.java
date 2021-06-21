package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CofigManager {//����ģʽ��ָ���ҽ���һ��ʵ��
	//��ȡ�����ļ�
	public static CofigManager cofigManager=null;
	public static Properties info=null;
	public CofigManager() {
		System.out.println("����ConfigManager������޲ι���......");
	  String configFile="jdbc.properties";
	  info=new Properties();
	  //ͨ��Classpath��ȡ��Դ��ͨ�������ڵ�Ŀ¼����Դ�ļ�
	  InputStream fis=CofigManager.class.getClassLoader().getResourceAsStream(configFile);
	    try {
			info.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���ʱ����һ��ȫ�ַ��ʵ�
	public static CofigManager getInstance(){
		if(cofigManager==null){
			cofigManager=new CofigManager();
		}
		return cofigManager;
	}

}
