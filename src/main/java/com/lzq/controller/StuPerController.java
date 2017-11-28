package com.lzq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzq.dao.ScMapper;
import com.lzq.po.CtcKey;
import com.lzq.po.Grade;
import com.lzq.po.Login;
import com.lzq.po.Sc;
import com.lzq.po.Student;
import com.lzq.service.LoginService;
import com.lzq.service.StuService;

@Controller
@RequestMapping("/stu")
public class StuPerController {
	@Resource
	StuService stuService;
	@Resource
	LoginService lService;
	@Resource
	ScMapper scMapper;
	@RequestMapping("/showInfo/{id}")
	public String getPerMsg(Model model, @PathVariable int id) {
		Student student = stuService.getstu(id);
		model.addAttribute("student", student);
		return "stu/person/list";
	}

	@RequestMapping("/updatePwd")
	public String updatePwd(Model model,Login login){
		lService.upStuPwd(login);
		model.addAttribute("msg", 1);
		return "stu/person/list";
		//res.getWriter().write("parent.location.href='views/login.jsp'");
	}

	@RequestMapping("/selectCourse/{classid}")
	public String selectCourse(Model model,@PathVariable int classid) {
		List<CtcKey> list = stuService.getclclist(classid);
		model.addAttribute("ctclist",list);
		return "stu/person/selectcourse";
	}
	
	@RequestMapping("/savecourse")
	public String savecourse(String[] ids,HttpServletRequest request,Model model) {
		Login login = (Login) request.getSession().getAttribute("user");
		int sid=login.getRid();
		List<Sc> sclist=new ArrayList<Sc>();
		for(String ctid:ids){
			Sc sc=new Sc();
			String[] ctidarray=ctid.split("_");
			sc.setCid(Integer.valueOf(ctidarray[0]));
			sc.setTid(Integer.valueOf(ctidarray[1]));
			sc.setSid(sid);
			sclist.add(sc);
		}
		scMapper.adds(sclist);
		List<Sc> list = stuService.getMyCourse(sid);
		model.addAttribute("stulist", list);
		return "/stu/person/mycourse";
	}
	@RequestMapping("/mycourse/{id}")
	public String mycourse(Model model,@PathVariable int id) {
		List<Sc> list = stuService.getMyCourse(id);
		model.addAttribute("stulist", list);
		return "stu/person/mycourse";
	}
	@RequestMapping("/getGrade/{id}")
	public String getGrade(Model model,@PathVariable int id) {
		List<Grade> list = stuService.getGrade(id);
		model.addAttribute("gradelist", list);
		return "stu/person/grade";
	}
}
