package com.bean;

import java.io.Serializable;

public class Clazz implements Serializable{
	private int clazzid;
	private String clazzname;
	
	
	public int getClazzid() {
		return clazzid;
	}
	public void setClazzid(int clazzid) {
		this.clazzid = clazzid;
	}
	public String getClazzname() {
		return clazzname;
	}
	public void setClazzname(String clazzname) {
		this.clazzname = clazzname;
	}
	
	
	
	public Clazz(int clazzid, String clazzname) {
		super();
		this.clazzid = clazzid;
		this.clazzname = clazzname;
	}
	public Clazz() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
