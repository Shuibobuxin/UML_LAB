package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ManagerDao;
import com.po.Manager;
import com.po.Teacher;

@Service("managerService")
public class ManagerService {
	@Resource(name = "managerDao")
	public ManagerDao managerDao;
	public Manager SelectManager() {
		return null;
	}
	public int Login(Manager m) {
		if(managerDao.selectManagerById(m) != null) {
			if(managerDao.selectManagerById(m).getPassword().equals(m.getPassword())) {
				return 1;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
	}
}
