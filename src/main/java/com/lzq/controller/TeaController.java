package com.lzq.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzq.po.Grade;
import com.lzq.po.Login;
import com.lzq.po.Sc;
import com.lzq.po.Teacher;
import com.lzq.service.TeaService;

@Controller
@RequestMapping("/tea")
public class TeaController {
	@Resource
	TeaService teaService;
	@RequestMapping
	public String getlist(Model model,@RequestParam(required=false,defaultValue="1")int pageNO){
		int size=3;
		List<Teacher> tlist = teaService.getlist(pageNO,size);
		model.addAttribute("tealist", tlist);
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("count", teaService.getcount());
		return "teacher/list";
	}
	@RequestMapping("/showInfo/{id}")
	public String showInfo(Model model,@PathVariable int id){
		Teacher teacher = teaService.gettea(id);
		model.addAttribute("teacher", teacher);
		return "teacher/person/list";
	}
	
	@RequestMapping("/mystu/{id}")
	public String mystu(Model model,@PathVariable int id){
		List<Sc> list = teaService.getstu(id);
		model.addAttribute("stulist", list);
		return "teacher/person/mystu";
	}
	@RequestMapping("/addgrade/{sid}/{cid}")
	public String addgrade(Model model,@PathVariable int sid ,@PathVariable int cid,HttpServletRequest request){
		Login user = (Login) request.getSession().getAttribute("user");
		int tid=user.getRid();
		Grade grade = new Grade();
		grade.setCid(cid);
		grade.setSid(sid);
		grade.setTid(tid);
		model.addAttribute("grade", grade);
		return "teacher/couOftea/setgrade";
	}
	@RequestMapping("/saveGrade")
	public String saveGrade(HttpServletRequest request,Model model,Grade grade){
		teaService.insert(grade);
		Login user = (Login) request.getSession().getAttribute("user");
		int tid=user.getRid();
		List<Sc> list = teaService.getstu(tid);
		model.addAttribute("stulist", list);
		return "teacher/person/mystu";
	}
}
