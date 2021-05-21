package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ClassDao;
import com.po.Class;

@Service("classService")
public class ClassService {
	@Resource(name = "classDao")
	public ClassDao classDao;
	
	public void InsertClass(Class c) {
		classDao.insertClass(c);
	}
	public int SelectClassByCourseId(int courseId){
		return classDao.NumberByCourseId(courseId);
	}
	public void DeleteClass(Class c) {
		classDao.deleteClass(c);
	}
	public List<Class> selectNotCloseClass(int studentId){
		return classDao.selectNotCloseClass(studentId);
	}
	public List<Class> selectAllNotCloseClass(){
		return classDao.selectAllNotCloseClass();
	}
	public List<Class> selectClassByTeacherId(int teacherId){
		return classDao.selectClassByTeacherId(teacherId);
	}
	public List<Class> selectEndClassByTeacherId(int teacherId){
		return classDao.selectEndClassByTeacherId(teacherId);
	}
	public Class SelectClassById(int classId) {
		return classDao.selectClassById(classId);
	}
	public void updateClass(Class c) {
		classDao.updateClass(c);
	}
}
