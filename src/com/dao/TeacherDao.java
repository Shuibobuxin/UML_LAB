package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Teacher;

@Repository("teacherDao")
@Mapper
public interface TeacherDao {
	public Teacher selectTeacherById(int teacherId);
	public List<Teacher> selectAllTeacher();
	public void insertTeacher(Teacher t);
	public void updateTeacher(Teacher t);
}
