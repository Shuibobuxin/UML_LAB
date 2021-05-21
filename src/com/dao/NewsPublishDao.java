package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.NewsPublish;

@Repository("newsPublishDao")
@Mapper
public interface NewsPublishDao {
	public NewsPublish selectNewsPublishById(int newsId);
	public List<NewsPublish> selectAllNewsPublish();
	public void insertNewsPublish(NewsPublish np);
	public void deleteNewsPublish(NewsPublish np);
}
