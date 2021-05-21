package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TeacherDao;
import com.po.Student;
import com.po.Teacher;

@Service("teacherService")
public class TeacherService {
	@Resource(name = "teacherDao")
	public TeacherDao teacherDao;
	public int Login(Teacher t) {
		if(teacherDao.selectTeacherById(t.getTeacherId()) != null) {
			if(teacherDao.selectTeacherById(t.getTeacherId()).getPassword().equals(t.getPassword())) {
				return 1;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
	}
	public boolean Register(Teacher t) {
		if(teacherDao.selectTeacherById(t.getTeacherId()) != null) {
			return false;
		}
		else {
			teacherDao.insertTeacher(t);
			return true;
		}
	}
	public Teacher selectTeacherById(int teacherId) {
		return teacherDao.selectTeacherById(teacherId);
	}
	public List<Teacher> selectAllTeacher(){
		return teacherDao.selectAllTeacher();
	}
	public void updateTeacher(Teacher teacher) {
		teacherDao.updateTeacher(teacher);
	}
}
