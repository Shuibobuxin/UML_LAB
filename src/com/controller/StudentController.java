package com.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Student;
import com.po.Class;
import com.po.ClassSelectInf;
import com.po.Course;
import com.service.ClassSelectInfService;
import com.service.ClassService;
import com.service.CourseService;
import com.service.StudentService;
import com.service.TeacherService;

@Controller("studentController")
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private ClassSelectInfService classSelectInfService;
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("student", new Student());
		return "studentLogin";		
	}
	@RequestMapping("/login.do")
	public String Dologin(@ModelAttribute Student student, Model model,HttpServletRequest request, HttpServletResponse response) {
		if(studentService.Login(student)==1) {
			//��¼�ɹ�
			request.setAttribute("s", student);
			return "studentIndex";
		}else if(studentService.Login(student)==0) {
			//�˻�����
			request.setAttribute("result", "��¼ʧ���˻�����");
			return "studentLogin";	
		}else {
			//�������
			request.setAttribute("result", "��¼ʧ���������");
			return "studentLogin";	
		}	
	}
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("student", new Student());
		return "studentRegister";
	}	
	@RequestMapping("/register.do")
	public String DoRegister(@ModelAttribute Student student, Model model, HttpServletRequest request) {
		if(student.getName()!=""&&student.getPassword()!=""&&student.getPhone()!=""&&student.getSex()!=""&&student.getStudentId()!=0) {
			if(studentService.Register(student)) {
				return "studentLogin";
			}else {
				request.setAttribute("result", "ע��ʧ�����и��˻����û���");
				return "studentRegister";
			}			
		}else {
			request.setAttribute("result", "ע��ʧ�����벻��Ϊ�գ����������룡");
			return "studentRegister";
		}
	}	
	
	@RequestMapping("/studentIndex")
	public String studentIndex(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		request.setAttribute("s", student);
		return "studentIndex";
	}
	@RequestMapping("/lInfLossReport")
	public String lInfLossReport(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		request.setAttribute("s", student);
		List<ClassSelectInf> csis = classSelectInfService.selectStudentCSI(studentId);
		request.setAttribute("csis", csis);
		request.setAttribute("SService", studentService);
		return "lInfLossReport";
	}
	@RequestMapping("/lInfLossReport.do")
	public String DolInfLossReport(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		if(student.getlSign()==1) {
			
			student.setlSign(0);
			request.setAttribute("result", "ȡ����ʧ�ɹ���");
			studentService.updateStudent(student);
		}else {
			
			student.setlSign(1);
			request.setAttribute("result", "��ʧ�ɹ�����ȴ�����Ա�����ʱ������ȡ��");
			studentService.updateStudent(student);
		}
		student = studentService.selectStudentById(studentId);
		request.setAttribute("s", student);
		List<ClassSelectInf> csis = classSelectInfService.selectStudentCSI(studentId);
		request.setAttribute("csis", csis);
		return "lInfLossReport";
	}
	@RequestMapping("/checkScore")
	public String checkScore(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		request.setAttribute("s", student);
		List<ClassSelectInf> csis = classSelectInfService.selectCSIByStudent(studentId);
		request.setAttribute("csis", csis);
		return "showStudentScore";
	}
	@RequestMapping("/changeStudentPw")
	public String changeStudentPw(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		request.setAttribute("s", student);
		return "changeStudentPw";
	}
	@RequestMapping("/changeStudentPw.do")
	public String DochangeStudentPw(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		request.setAttribute("s", student);
		String pw1 = request.getParameter("password1");
		String pw2 = request.getParameter("password2");
		if(pw1!=""&&pw2!="") {
			if(pw1.equals(pw2)) {
				student.setPassword(pw1);
				studentService.updateStudent(student);
				request.setAttribute("result", "�޸ĳɹ���");
				return "studentIndex";
			}else {
				request.setAttribute("result", "�޸�ʧ��������������벻һ�£����������룡");
				return "changeStudentPw";
			}
			
		}else {
			request.setAttribute("result", "�޸�ʧ�����벻��Ϊ�գ����������룡");
			return "changeStudentPw";
		}
	}
	@RequestMapping("/selectClass")
	public String selectClass(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		request.setAttribute("s", student);
		List<Class> NCloseClasses = classService.selectNotCloseClass(studentId);
		request.setAttribute("NCloseClasses", NCloseClasses);
		request.setAttribute("TService", teacherService);
		request.setAttribute("CService", courseService);
		return "selectClass";
	}
	@RequestMapping("/selectClass.do")
	public String DoselectClass(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int classId = Integer.parseInt(request.getParameter("classId"));
		Student student = studentService.selectStudentById(studentId);
		ClassSelectInf csi = new ClassSelectInf();
		Class c = classService.SelectClassById(classId);
		if(c.getNumberNow()<c.getNumberMax()) {
			int temp = c.getNumberNow()+1;
			c.setNumberNow(temp);
			classService.updateClass(c);
		}
		Course course = courseService.SelectCourseById(c.getCourseId());
		
		csi.setClassId(classId);
		csi.setStudentId(studentId);
		csi.setCourseName(course.getCourseName());
		
		classSelectInfService.InsertCSI(csi);
		
		request.setAttribute("s", student);
		List<Class> NCloseClasses = classService.selectNotCloseClass(studentId);
		request.setAttribute("NCloseClasses", NCloseClasses);
		request.setAttribute("TService", teacherService);
		request.setAttribute("CService", courseService);
		request.setAttribute("result", "ѡ�γɹ���");
		return "selectClass";
	}
	@RequestMapping("/changeStudentInf")
	public String changeStudentInf(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		request.setAttribute("s", student);
		model.addAttribute("student",student);
		return "changeStudentInf";
	}
	@RequestMapping("/changeStudentInf.do")
	public String DochangeStudentInf(@ModelAttribute Student student,Model model, HttpServletRequest request) {
		if(student.getName()!=""&&student.getPhone()!="") {
			request.setAttribute("result", "�޸ĳɹ���");
			studentService.updateStudent(student);
			request.setAttribute("s", student);
			return "changeStudentInf";
		}else {
			request.setAttribute("result", "�޸�ʧ�����벻��Ϊ�գ����������룡");
			request.setAttribute("s", student);
			return "changeStudentInf";
		}
	}
}
