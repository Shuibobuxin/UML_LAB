package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.ClassSelectInf;
import com.po.Class;

@Repository("classSelectInfDao")
@Mapper
public interface ClassSelectInfDao {
	public List<ClassSelectInf> selectCSIByStudent(int studentId);
	public List<ClassSelectInf> selectStudentCSI(int studentId);
	public List<ClassSelectInf> selectAllCSI();
	public List<ClassSelectInf> selectCSIByCId(Class c);
	public void insertCSI(ClassSelectInf CSI);
	public void deleteCSI(ClassSelectInf CSI);
	public void updateCSI(ClassSelectInf CSI);
}
