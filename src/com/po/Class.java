package com.po;

import java.sql.Date;

public class Class {
	private int classId;
	private int teacherId;
	private int courseId;
	private int numberNow;
	private int numberMax;
	private String year;
	private String season;
	private int closeSign;//关选标记
	private int endSign;//结课标记
	private Date time;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getNumberNow() {
		return numberNow;
	}
	public void setNumberNow(int numberNow) {
		this.numberNow = numberNow;
	}
	public int getNumberMax() {
		return numberMax;
	}
	public void setNumberMax(int numberMax) {
		this.numberMax = numberMax;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public int getCloseSign() {
		return closeSign;
	}
	public void setCloseSign(int closeSign) {
		this.closeSign = closeSign;
	}
	public int getEndSign() {
		return endSign;
	}
	public void setEndSign(int endSign) {
		this.endSign = endSign;
	}
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
