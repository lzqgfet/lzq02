package com.lzq.service;

import java.util.List;

import com.lzq.po.Grade;
import com.lzq.po.Sc;
import com.lzq.po.Teacher;

public interface TeaService {
	List<Teacher> getlist(int pageNO,int size);
	int getcount();
	Teacher gettea(int id);
	List<Sc> getstu(int id);
	int insert(Grade grade);
}
