package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Student;

@Repository("studentDao")
@Mapper
public interface StudentDao {
	public Student selectStudentById(int studentId);
	public List<Student> selectAllStudent();
	public List<Student> selectStudentBylSign();
	public void insertStudent(Student s);
	public void updateStudent(Student s);
}
