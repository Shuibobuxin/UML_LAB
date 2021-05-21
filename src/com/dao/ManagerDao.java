package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Manager;

@Repository("managerDao")
@Mapper
public interface ManagerDao {
	public Manager selectManagerById(Manager m);
	public void updateManagerPassword(Manager m);
}
