package com.lzq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lzq.po.Classes;
import com.lzq.service.ClaService;

@Controller
@RequestMapping("/cla")
public class ClaController {
	@Autowired
	ClaService claService;
	@RequestMapping
	public String getlist(Model model,@RequestParam(required=false,defaultValue="1")int pageNO){
		int size=3;
		List<Classes> list = claService.getlist(pageNO,size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("size", size);
		model.addAttribute("count", claService.getcount());
		model.addAttribute("clalist", list);
		return "class/list";
	}
	@RequestMapping("/searchstu/{id}")
	public String searchstu(Model model,@PathVariable int id){
		List<Classes> list = claService.getslist(id);
		model.addAttribute("clist", list);
		return "class/stulist1";
	}
}
