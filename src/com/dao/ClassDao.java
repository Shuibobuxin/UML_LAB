package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Class;
@Repository("classDao")
@Mapper
public interface ClassDao {
	public Class selectClassById(int classId);
	public List<Class> selectAllClass();
	public void insertClass(Class c);
	public void updateClass(Class c);
	public int NumberByCourseId(int courseId);
	public void deleteClass(Class c);
	public List<Class> selectNotCloseClass(int studentId);
	public List<Class> selectAllNotCloseClass();
	public List<Class> selectClassByTeacherId(int teacherId);
	public List<Class> selectEndClassByTeacherId(int teacherId);
}
