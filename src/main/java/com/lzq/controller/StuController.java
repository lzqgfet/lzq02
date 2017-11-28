package com.lzq.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzq.dao.LoginMapper;
import com.lzq.po.Classes;
import com.lzq.po.StuExte;
import com.lzq.po.Student;
import com.lzq.service.StuService;

@Controller
@RequestMapping("/stu")
public class StuController {
	@Resource
	StuService stuService;
	@Resource
	LoginMapper loginMapper;
	@RequestMapping
	public String getlist(Model model,@RequestParam(required=false,defaultValue="1")int pageNO){
		int size=3;
		List<Student> slist = stuService.getlist(pageNO, size);
		model.addAttribute("slist", slist);
		model.addAttribute("count", stuService.getcount());
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		return "stu/list";
	}
	@RequestMapping("/showadd")
	public String showadd(Model model){
		List<Classes> clalist = stuService.getclist();
		model.addAttribute("student",new StuExte());
		model.addAttribute("clalist", clalist);
		return "stu/add";
	}
	@RequestMapping("/add")
	public String add(StuExte stu){
		stuService.StuSandA(stu);
		return "redirect:/stu";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		stuService.deletestu(id);
		return "redirect:/stu";
	}
	@RequestMapping("/showedit")
	public String getstu(Model model,int id){
		List<Classes> clalist = stuService.getclist();
		Student stu = stuService.getstu(id);
		model.addAttribute("student",stu);
		model.addAttribute("clalist", clalist);
		return "stu/edit";
	}
	@RequestMapping("/edit")
	public String edit(Student stu){
		stuService.update(stu);
		return "redirect:/stu";
	}
	@RequestMapping("deletes")
	public String deleteMany(@RequestParam(required=false, defaultValue="-1") int[] id,Model model){
		
			StringBuffer sb=new StringBuffer();
			for(int i:id){
				sb.append(i+",");
			}
			String s= sb.toString().substring(0, sb.lastIndexOf(","));
			if(s.contains("-1")){
				model.addAttribute("msg", "-1");
				return "redirect:/stu";
			}else{
				stuService.deleteMany(s);
				return "redirect:/stu";
			}
	}
}
