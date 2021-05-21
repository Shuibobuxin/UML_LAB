package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Student;
import com.po.Teacher;
import com.po.Class;
import com.po.ClassSelectInf;
import com.po.Course;
import com.service.ClassSelectInfService;
import com.service.ClassService;
import com.service.CourseService;
import com.service.StudentService;
import com.service.TeacherService;

@Controller("teacherController")
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClassService classService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private ClassSelectInfService classSelectInfService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("teacher",new Teacher());
		return "teacherLogin";		
	}
	@RequestMapping("/login.do")
	public String Dologin(@ModelAttribute Teacher teacher, Model model,HttpServletRequest request, HttpServletResponse response) {
		if(teacherService.Login(teacher)==1) {
			//登录成功
			request.setAttribute("t", teacher);
			return "teacherIndex";
		}else if(teacherService.Login(teacher)==0) {
			//账户错误
			request.setAttribute("result", "登录失败账户错误！");
			return "teacherLogin";	
		}else {
			//密码错误
			request.setAttribute("result", "登录失败密码错误！");
			return "teacherLogin";	
		}	
	}
	@RequestMapping("/teacherIndex")
	public String teacherIndex(Model model,HttpServletRequest request) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		request.setAttribute("t", teacher);
		return "teacherIndex";
	}
	@RequestMapping("/changeTeacherPw")
	public String changeStudentPw(Model model, HttpServletRequest request) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		request.setAttribute("t", teacher);
		return "changeTeacherPw";
	}
	@RequestMapping("/changeTeacherPw.do")
	public String DochangeStudentPw(Model model, HttpServletRequest request) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		request.setAttribute("t", teacher);
		String pw1 = request.getParameter("password1");
		String pw2 = request.getParameter("password2");
		if(pw1!=""&&pw2!="") {
			if(pw1.equals(pw2)) {
				teacher.setPassword(pw1);
				teacherService.updateTeacher(teacher);
				request.setAttribute("result", "修改成功！");
				return "teacherIndex";
			}else {
				request.setAttribute("result", "修改失败输入的两次密码不一致，请重新输入！");
				return "changeTeacherPw";
			}
			
		}else {
			request.setAttribute("result", "修改失败输入不能为空，请重新输入！");
			return "changeTeacherPw";
		}
	}
	@RequestMapping("/checkScore")
	public String checkScore(Model model, HttpServletRequest request) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		request.setAttribute("t", teacher);
		List<Class> classes = classService.selectEndClassByTeacherId(teacherId);
		request.setAttribute("classes", classes);
		request.setAttribute("CService", courseService);
		return "checkScore";
	}
	@RequestMapping("/checkScore.do")
	public String DocheckScore(Model model, HttpServletRequest request) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		int classId = Integer.parseInt(request.getParameter("classId"));
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		Class c = classService.SelectClassById(classId);
		
		request.setAttribute("t", teacher);
		request.setAttribute("c", c);
		Course course = courseService.SelectCourseById(c.getCourseId());
		List<ClassSelectInf> csis = classSelectInfService.selectCSIByCId(c);
		request.setAttribute("csis", csis);
		request.setAttribute("courseName", course.getCourseName());
		request.setAttribute("SService", studentService);
		return "showClassScore";
	}
	@RequestMapping("/addScore")
	public String addScore(Model model, HttpServletRequest request) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		request.setAttribute("t", teacher);
		List<Class> classes = classService.selectClassByTeacherId(teacherId);
		request.setAttribute("classes", classes);
		request.setAttribute("CService", courseService);
		return "addScore";
	}
	@RequestMapping("/addScore.do")
	public String DoaddScore(Model model, HttpServletRequest request) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		int classId = Integer.parseInt(request.getParameter("classId"));
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		Class c = classService.SelectClassById(classId);
		
		request.setAttribute("t", teacher);
		request.setAttribute("c", c);
		
		List<ClassSelectInf> csis = classSelectInfService.selectCSIByCId(c);
		request.setAttribute("csis", csis);
		request.setAttribute("SService", studentService);
		return "addClassScore";
	}
	@RequestMapping("/addClassScore")
	public String addClassScore(Model model, HttpServletRequest request) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		int classId = Integer.parseInt(request.getParameter("classId"));
		Teacher teacher = teacherService.selectTeacherById(teacherId);
		Class c = classService.SelectClassById(classId);
		List<ClassSelectInf> csis = classSelectInfService.selectCSIByCId(c);
		request.setAttribute("t", teacher);
		request.setAttribute("c", c);
		request.setAttribute("csis", csis);
		request.setAttribute("SService", studentService);
		for(int i=0;i<csis.size();i++) {
			if(request.getParameter(String.valueOf(csis.get(i).getStudentId()))=="") {
				request.setAttribute("result", "录入成绩失败，输入不能为空，请重新输入！");
				return "addClassScore";
			}
		}
		for(int i=0;i<csis.size();i++) {		
			float score = Float.parseFloat(request.getParameter(String.valueOf(csis.get(i).getStudentId())));
			System.out.println(score);
			if(score>100||score<0) {
				request.setAttribute("result", "录入成绩失败，成绩范围为0-100，请重新输入！");
				return "addClassScore";
			}
		}
		for(int i=0;i<csis.size();i++) {		
			float score = Float.parseFloat(request.getParameter(String.valueOf(csis.get(i).getStudentId())));
			csis.get(i).setScore(score);
			classSelectInfService.updataCSI(csis.get(i));
		}
		c.setEndSign(1);
		classService.updateClass(c);
		request.setAttribute("result", "录入成功！");
		return "addScore";
	}
}
