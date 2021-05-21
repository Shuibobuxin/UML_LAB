package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.NewsPublishDao;
import com.po.NewsPublish;

@Service("newsPublishService")
public class NewsPublishService {
	@Resource(name = "newsPublishDao")
	public NewsPublishDao newsPublishDao;
	public List<NewsPublish> SelectAllNewsPublish(){
		return newsPublishDao.selectAllNewsPublish();
	}
	public void InsertNewsPublish(NewsPublish np) {
		newsPublishDao.insertNewsPublish(np);
	}
	public void deleteNewsPublish(NewsPublish np) {
		newsPublishDao.deleteNewsPublish(np);
	}
	public NewsPublish SelectNewsPublishByNewsId(int newsId) {
		return newsPublishDao.selectNewsPublishById(newsId);
	}
}
