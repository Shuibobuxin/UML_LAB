package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Course;
import com.po.Class;
import com.po.ClassSelectInf;
import com.po.Manager;
import com.po.News;
import com.po.NewsPublish;
import com.po.Student;
import com.po.Teacher;
import com.service.ClassSelectInfService;
import com.service.ClassService;
import com.service.CourseService;
import com.service.ManagerService;
import com.service.NewsPublishService;
import com.service.NewsService;
import com.service.StudentService;
import com.service.TeacherService;

@Controller("managerController")
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private ClassService classService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private NewsPublishService newsPublishService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassSelectInfService classSelectInfService;
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("manager",new Manager());
		return "managerLogin";		
	}
	@RequestMapping("/login.do")
	public String Dologin(@ModelAttribute Manager manager, Model model,HttpServletRequest request, HttpServletResponse response) {
		if(managerService.Login(manager)==1) {
			//登录成功
			return "managerIndex";
		}else if(managerService.Login(manager)==0) {
			//账户错误
			request.setAttribute("result", "登录失败账户错误！");
			return "managerLogin";	
		}else {
			//密码错误
			request.setAttribute("result", "登录失败密码错误！");
			return "managerLogin";	
		}	
	}
	@RequestMapping("/managerIndex")
	public String managerIndex(Model model) {
		return "managerIndex";
	}
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "teacherRegister";
	}	
	@RequestMapping("/register.do")
	public String DoRegister(@ModelAttribute Teacher teacher, Model model, HttpServletRequest request) {
		if(teacher.getName()!=""&&teacher.getPassword()!=""&&teacher.getPhone()!=""&&teacher.getSex()!=""&&teacher.getTeacherId()!=0&&teacher.getTeacherInf()!="") {
			if(teacherService.Register(teacher)) {
				request.setAttribute("result", "注册成功！");
				return "managerIndex";
			}else {
				request.setAttribute("result", "注册失败已有该账户的用户！");
				return "teacherRegister";
			}			
		}else {
			request.setAttribute("result", "注册失败输入不能为空，请重新输入！");
			return "teacherRegister";
		}
	}
	@RequestMapping("/manageTeacher")
	public String manageTeacher(Model model) {
		return "manageTeacher";
	}
	@RequestMapping("/manageNews")
	public String manageNews(Model model) {
		return "manageNews";
	}
	@RequestMapping("/manageCourse")
	public String manageCourse(Model model) {
		return "manageCourse";
	}
	@RequestMapping("/manageClass")
	public String manageClass(Model model) {
		return "manageClass";
	}
	@RequestMapping("/listNews")
	public String listNews(HttpServletRequest request, HttpServletResponse response) {
		List<News> newsL = newsService.SelectAllNews();
		request.setAttribute("newsL", newsL);
		return "listNews";
	}
	@RequestMapping("/changeNewsInf")
	public String changeNewsInf(Model model, HttpServletRequest request, HttpServletResponse response) {
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		News news = newsService.SelectNewsById(newsId);
		request.setAttribute("n", news);
		model.addAttribute("news", news);
		return "changeNewsInf";
	}
	@RequestMapping("/changeNewsInf.do")
	public String DochangeNewsInf(@ModelAttribute News news,Model model, HttpServletRequest request, HttpServletResponse response) {
		if(news.getText()!=""&&news.getTitle()!="") {
			newsService.updateNews(news);
			request.setAttribute("result", "修改成功！");
			List<News> newsL = newsService.SelectAllNews();
			request.setAttribute("newsL", newsL);
			return "listNews";
		}else {
			request.setAttribute("result", "修改失败，输入不能为空！");
			return "changeNewsInf";
		}	
	}
	@RequestMapping("/addNews")
	public String addNews(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("news", new News());
		return "addNews";
	}
	@RequestMapping("/addNews.do")
	public String DoaddNews(@ModelAttribute News news,Model model, HttpServletRequest request, HttpServletResponse response) {
		if(news.getText()!=""&&news.getTitle()!="") {
			newsService.InsertNews(news);
			request.setAttribute("result", "添加成功！");
			return "manageNews";
		}else {
			request.setAttribute("result", "添加失败，输入不能为空！");
			return "addNews";
		}
	}
	@RequestMapping("/changeNewsPublish")
	public String changeNewsPublish(HttpServletRequest request, HttpServletResponse response) {
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		News news = newsService.SelectNewsById(newsId);
		if(news.getPublishSign()==0) {
			news.setPublishSign(1);
			NewsPublish np = new NewsPublish();
			np.setNewsId(newsId);
			java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
			np.setPublishTime(date);
			newsPublishService.InsertNewsPublish(np);
			newsService.updateNews(news);
		}else {
			news.setPublishSign(0);	
			NewsPublish np =newsPublishService.SelectNewsPublishByNewsId(newsId);
			newsPublishService.deleteNewsPublish(np);
			newsService.updateNews(news);
		}
		List<News> newsL = newsService.SelectAllNews();
		request.setAttribute("newsL", newsL);
		return "listNews";
	}
	@RequestMapping("/listTeacher")
	public String listTeacher(HttpServletRequest request, HttpServletResponse response) {
		List<Teacher> teachsers = teacherService.selectAllTeacher();
		request.setAttribute("teachers", teachsers);
		return "listTeacher";
	}
	@RequestMapping("/changeTeacherInf")
	public String changeTeacherInf(Model model, HttpServletRequest request, HttpServletResponse response) {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher t = teacherService.selectTeacherById(teacherId);
		request.setAttribute("t", t);
		model.addAttribute("teacher", t);
		return "changeTeacherInf";
	}
	@RequestMapping("/changeTeacherInf.do")
	public String DochangeTeacherInf(@ModelAttribute Teacher teacher,Model model, HttpServletRequest request, HttpServletResponse response) {
		if(teacher.getName()!=""&&teacher.getPhone()!=""&&teacher.getSex()!=""&&teacher.getTeacherInf()!="") {
			request.setAttribute("result", "修改成功！");
			teacherService.updateTeacher(teacher);
			List<Teacher> teachsers = teacherService.selectAllTeacher();
			request.setAttribute("teachers", teachsers);
			return "listTeacher";
		}else {
			request.setAttribute("result", "修改失败输入不能为空，请重新输入！");
			return "changeTeacherInf";
		}
	}
	@RequestMapping("/addCourse")
	public String addCourse(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("course", new Course());
		return "addCourse";
	}
	@RequestMapping("/addCourse.do")
	public String DoaddCourse(@ModelAttribute Course course,Model model, HttpServletRequest request, HttpServletResponse response) {
		if(course.getCourseInf()!=""&&course.getCourseName()!=""&&course.getCourseSign()!=0) {
			courseService.InsertCourse(course);
			request.setAttribute("result", "添加成功！");
			return "manageCourse";			
		}else {
			request.setAttribute("result", "添加失败输入不能为空，请重新输入！");
			return "addCourse";
		}
	}
	@RequestMapping("/listCourse")
	public String listCourse(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Course> courses = courseService.SelectAllCourse();
		request.setAttribute("courses", courses);
		return "listCourse";
	}	
	@RequestMapping("/changeCourseSign")
	public String changeCourseSign(Model model, HttpServletRequest request, HttpServletResponse response) {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		Course course = courseService.SelectCourseById(courseId);
		if(course.getCourseSign()==1) {
			course.setCourseSign(0);
			courseService.updateCourse(course);
		}else {
			course.setCourseSign(1);
			courseService.updateCourse(course);
		}
		request.setAttribute("result", "设置成功！");
		List<Course> courses = courseService.SelectAllCourse();
		request.setAttribute("courses", courses);
		return "listCourse";
	}	
	@RequestMapping("/changeCourseInf")
	public String changeCourseInf(Model model, HttpServletRequest request, HttpServletResponse response) {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		Course course = courseService.SelectCourseById(courseId);
		request.setAttribute("c", course);
		model.addAttribute("course", course);
		return "changeCourseInf";
	}
	@RequestMapping("/changeCourseInf.do")
	public String DochangeCourseInf(@ModelAttribute Course course,Model model, HttpServletRequest request, HttpServletResponse response) {
		if(course.getCourseName()!=""&&course.getCourseInf()!=""&&course.getCourseId()!=0) {
			request.setAttribute("result", "修改成功！");
			courseService.updateCourse(course);
			List<Course> courses = courseService.SelectAllCourse();
			request.setAttribute("courses", courses);
			return "listCourse";
		}else {
			request.setAttribute("result", "修改失败输入不能为空，请重新输入！");
			return "changeCourseInf";
		}
	}
	@RequestMapping("/deleteCourse")
	public String deleteCourse(Model model, HttpServletRequest request, HttpServletResponse response) {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		if(classService.SelectClassByCourseId(courseId)>0) {
			List<Course> courses = courseService.SelectAllCourse();
			request.setAttribute("courses", courses);
			request.setAttribute("result", "删除失败，不能删除已开设过班级的课程！");
			return "listCourse";
		}else {
			courseService.DeleteCourse(courseService.SelectCourseById(courseId));
			List<Course> courses = courseService.SelectAllCourse();
			request.setAttribute("courses", courses);
			request.setAttribute("result", "删除成功！");
			return "listCourse";
		}
	}
	@RequestMapping("/addClass")
	public String addClass(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("class", new Class());
		List<Teacher> teachers = teacherService.selectAllTeacher();
		request.setAttribute("teachers", teachers);		
		List<Course> courses = courseService.SelectAllCourse();
		request.setAttribute("courses", courses);	
		return "addClass";
	}
	@RequestMapping("/addClass.do")
	public String DoaddClass(@ModelAttribute Class c,Model model, HttpServletRequest request, HttpServletResponse response) {
		if(c.getNumberMax()!=0&&c.getSeason()!=""&&c.getYear()!=""&&c.getTeacherId()!=0&&c.getCourseId()!=0) {
			request.setAttribute("result", "添加成功！");
			java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
			System.out.println(date);
			c.setTime(date);
			classService.InsertClass(c);
			return "manageClass";
		}else {
			request.setAttribute("result", "添加失败输入不能为空，请重新输入！");
			List<Teacher> teachers = teacherService.selectAllTeacher();
			request.setAttribute("teachers", teachers);		
			List<Course> courses = courseService.SelectAllCourse();
			request.setAttribute("courses", courses);
			return "addClass";
		}
	}
	@RequestMapping("/closeClass")
	public String closeClass(Model model, HttpServletRequest request, HttpServletResponse response) {
	
		List<Class> classes = classService.selectAllNotCloseClass();
		request.setAttribute("classes", classes);	
		request.setAttribute("CService", courseService);	
		return "closeClass";
	}
	@RequestMapping("/closeClass.do")
	public String DocloseClass(Model model, HttpServletRequest request, HttpServletResponse response) {
		int classId = Integer.parseInt(request.getParameter("classId"));
		Class c = classService.SelectClassById(classId);
		c.setCloseSign(1);
		classService.updateClass(c);
		List<Class> classes = classService.selectAllNotCloseClass();
		request.setAttribute("classes", classes);	
		request.setAttribute("CService", courseService);
		request.setAttribute("result", "关闭成功！");
		return "closeClass";
	}
	@RequestMapping("/StudentCSI")
	public String StudentCSI(Model model, HttpServletRequest request, HttpServletResponse response) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		List<ClassSelectInf> csis = classSelectInfService.selectStudentCSI(studentId);
		request.setAttribute("csis", csis);	
		return "StudentCSI";
	}
	@RequestMapping("/lInfMakeUp")
	public String lInfMakeUp(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		List<Student> students = studentService.selectStudentBylSign();
		request.setAttribute("students", students);	
		return "lInfMakeUp";
	}
	@RequestMapping("/lInfMakeUp.do")
	public String DolInfMakeUp(Model model, HttpServletRequest request, HttpServletResponse response) {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student student = studentService.selectStudentById(studentId);
		student.setlSign(0);
		studentService.updateStudent(student);
		List<Student> students = studentService.selectStudentBylSign();
		request.setAttribute("students", students);	
		request.setAttribute("result", "补办成功，请通知学员及时领取新听课证！");
		return "lInfMakeUp";
	}
	@RequestMapping("showNews")
	public String showNews(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<NewsPublish> newsps = newsPublishService.SelectAllNewsPublish();
		NewsPublish temp = null;
		for(int i=0;i<newsps.size()/2;i++) {
			temp = newsps.get(i);
			newsps.set(i, newsps.get(newsps.size()-i-1));
			newsps.set(newsps.size()-i-1,temp);
		}
		request.setAttribute("newsps", newsps);	
		request.setAttribute("NService", newsService);	
		return "index";
	}
	@RequestMapping("showTheNews")
	public String showTheNews(Model model, HttpServletRequest request, HttpServletResponse response) {
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		String publishTime  = request.getParameter("publishTime");
		News news = newsService.SelectNewsById(newsId);
		request.setAttribute("news", news);	
		request.setAttribute("publishTime", publishTime);	
		return "showTheNews";
	}
}
