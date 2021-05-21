package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Course;

@Repository("courseDao")
@Mapper
public interface CourseDao {
	public Course selectCourseById(int courseId);
	public List<Course> selectAllCourse();
	public void updateCourse(Course c);
	public void deleteCourse(Course c);
	public void insertCourse(Course c);
}
