package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.po.Student;

@Service("studentService")
public class StudentService {
	@Resource(name = "studentDao")
	public StudentDao studentDao;
	public int Login(Student s) {
		if(studentDao.selectStudentById(s.getStudentId()) != null) {
			if(studentDao.selectStudentById(s.getStudentId()).getPassword().equals(s.getPassword())) {
				return 1;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
	}
	public boolean Register(Student s) {
		if(studentDao.selectStudentById(s.getStudentId()) != null) {
			return false;
		}
		else {
			studentDao.insertStudent(s);
			return true;
		}
	}
	public Student selectStudentById(int studentId) {
		return studentDao.selectStudentById(studentId);
	}
	public List<Student> selectAllStudent(){
		return studentDao.selectAllStudent();
	}
	public List<Student> selectStudentBylSign(){
		return studentDao.selectStudentBylSign();
	}
	public void updateStudent(Student s) {
		studentDao.updateStudent(s);
	}
}
