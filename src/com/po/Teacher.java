package com.po;

public class Teacher {
	private int teacherId;
	private String password;
	private String name;
	private String sex;
	private String phone;
	private String teacherInf;
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTeacherInf() {
		return teacherInf;
	}
	public void setTeacherInf(String teacherInf) {
		this.teacherInf = teacherInf;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
}
