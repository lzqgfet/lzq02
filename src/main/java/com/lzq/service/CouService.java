package com.lzq.service;

import java.util.List;

import com.lzq.po.CouExte;
import com.lzq.po.Course;
import com.lzq.po.Teacher;

public interface CouService {
	public List<Course> getlist(int pageNO,int size);
	int getcount();
	public List<Teacher> getAll();
	public CouExte getcou(int id);
	public void setct(CouExte couExte);
}
