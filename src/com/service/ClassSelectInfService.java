package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ClassSelectInfDao;
import com.po.ClassSelectInf;
import com.po.Class;

@Service("classSelectInfService")
public class ClassSelectInfService {
	@Resource(name = "classSelectInfDao")
	public ClassSelectInfDao classSelectInfDao;
	
	public void InsertCSI(ClassSelectInf csi) {
		classSelectInfDao.insertCSI(csi);
	}
	public List<ClassSelectInf> selectCSIByCId(Class c){
		return classSelectInfDao.selectCSIByCId(c);
	}
	public List<ClassSelectInf> selectCSIByStudent(int studentId){
		return classSelectInfDao.selectCSIByStudent(studentId);
	}
	public List<ClassSelectInf> selectStudentCSI(int studentId){
		return classSelectInfDao.selectStudentCSI(studentId);
	}
	public void updataCSI(ClassSelectInf csi) {
		classSelectInfDao.updateCSI(csi);
	}
}
