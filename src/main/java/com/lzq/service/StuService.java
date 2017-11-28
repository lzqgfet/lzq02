package com.lzq.service;

import java.util.List;

import com.lzq.po.Classes;
import com.lzq.po.CtcKey;
import com.lzq.po.Grade;
import com.lzq.po.Login;
import com.lzq.po.Sc;
import com.lzq.po.StuExte;
import com.lzq.po.Student;

public interface StuService {
	public List<Student> getlist(int pageNO,int size);
	public int getcount();
	public void StuSandA(StuExte stu);
	public List<Classes> getclist();
	int deletestu(int id);
	Student getstu(int id);
	void deleteMany(String s);
	void update(Student stu);
	List<CtcKey> getclclist(int classid);
	int getclaid(Login login);
	void selcou(int claid,int[] ids,int sid);
	List<Sc> getMyCourse(int id);
	List<Grade> getGrade(int id);
}
