package com.lzq.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzq.po.Classes;
import com.lzq.po.CouExte;
import com.lzq.po.Course;
import com.lzq.po.Teacher;
import com.lzq.service.CouService;
import com.lzq.service.StuService;

@Controller
@RequestMapping("/cou")
public class CouController {
	@Resource
	CouService couService;
	@Resource
	StuService stuService;
	@RequestMapping
	public String getlist(Model model,@RequestParam(required=false,defaultValue="1")int pageNO){
		int size=5;
		List<Course> coulist = couService.getlist(pageNO, size);
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("count", couService.getcount());
		model.addAttribute("coulist", coulist);
		return "course/list";
	}
	@RequestMapping("/ctc/{id}")
	public String ctc(Model model,@PathVariable int id){
		CouExte couExte=couService.getcou(id);
		List<Teacher> tealist = couService.getAll();
		List<Classes> clalist = stuService.getclist();
		model.addAttribute("couExte", couExte);
		model.addAttribute("tealist", tealist);
		model.addAttribute("clalist", clalist);
		return "course/setct";
	}
	@RequestMapping("/editSavect")
	public String editSavect(CouExte couExte){
		couService.setct(couExte);
		return "redirect:/cou";
	}
}
