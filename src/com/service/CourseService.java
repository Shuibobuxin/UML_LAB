package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CourseDao;
import com.po.Course;

@Service("courseService")
public class CourseService {
	@Resource(name = "courseDao")
	public CourseDao courseDao;
	public void InsertCourse(Course course) {
		courseDao.insertCourse(course);
	}
	public List<Course> SelectAllCourse(){
		return courseDao.selectAllCourse();
	}
	public Course SelectCourseById(int courseId) {
		return courseDao.selectCourseById(courseId);
	}
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}
	public void DeleteCourse(Course c) {
		courseDao.deleteCourse(c);
	}
}
