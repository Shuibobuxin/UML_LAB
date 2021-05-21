package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.News;

@Repository("newsDao")
@Mapper
public interface NewsDao {
	public News selectNewsById(int newsId);
	public List<News> selectAllNews();
	public void updateNews(News n);
	public void deleteNews(News n);
	public void insertNews(News n);
}
