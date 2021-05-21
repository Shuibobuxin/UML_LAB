package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.NewsDao;
import com.po.News;

@Service("newsService")
public class NewsService {
	@Resource(name = "newsDao")
	public NewsDao newsDao;
	
	public List<News> SelectAllNews(){
		return newsDao.selectAllNews();
	}
	public void InsertNews(News news) {
		newsDao.insertNews(news);
	}
	public News SelectNewsById(int newsId) {
		return newsDao.selectNewsById(newsId);
	}
	public void updateNews(News news) {
		newsDao.updateNews(news);
	}
}
