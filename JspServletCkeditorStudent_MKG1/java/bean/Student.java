package com.bean;

import java.io.Serializable;

public class Student implements Serializable {
	private int sid;
	private String sname;
	private String sex;
	private String addrs;
	private String birthday;
	private String picname;
	private int classid;
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", addrs=" + addrs + ", birthday="
				+ birthday + ", picname=" + picname + ", classid=" + classid + ", classname=" + classname + "]";
	}

	private String classname;
	

	
	public Student(int sid, String sname, String sex, String addrs, String birthday, int classid, String classname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.addrs = addrs;
		this.birthday = birthday;
		this.classid = classid;
		this.classname = classname;
		System.out.println("调用有参构�??");
	}

	//增加业务专用的有参构�?
	public Student(String sname, String sex, String addrs, String birthday, String picname, int classid) {
		super();
		this.sname = sname;
		this.sex = sex;
		this.addrs = addrs;
		this.birthday = birthday;
		this.picname = picname;
		this.classid = classid;
	}
   //查询专用的有参构�?
	public Student(int sid, String sname, String sex, String addrs, String birthday, int classid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.addrs = addrs;
		this.birthday = birthday;
		this.classid = classid;
		System.out.println("调用查询专用的有参构�?");
	}
	
	//修改专用
	public Student(int sid, String sname, String sex, String addrs, String birthday, String picname, int classid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.addrs = addrs;
		this.birthday = birthday;
		this.picname = picname;
		this.classid = classid;
		System.out.println("调用修改专用的有参构�?");
	}
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, String sex, String addrs, String birthday, String picname, int classid,
			String classname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.addrs = addrs;
		this.birthday = birthday;
		this.picname = picname;
		this.classid = classid;
		this.classname = classname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	
	
}
