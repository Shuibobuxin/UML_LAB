package com.po;

import java.sql.Date;

public class NewsPublish {
	private int newsPublishId;
	private int newsId;
	private Date publishTime;
	public int getNewsPublishId() {
		return newsPublishId;
	}
	public void setNewsPublishId(int newsPublishId) {
		this.newsPublishId = newsPublishId;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public NewsPublish() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
