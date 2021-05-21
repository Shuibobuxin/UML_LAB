package com.po;

public class News {
	private int newsId;
	private String title;
	private String text;
	private int publishSign;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getPublishSign() {
		return publishSign;
	}
	public void setPublishSign(int publishSign) {
		this.publishSign = publishSign;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
