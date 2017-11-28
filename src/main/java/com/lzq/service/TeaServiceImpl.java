package com.lzq.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzq.dao.GradeMapper;
import com.lzq.dao.ScMapper;
import com.lzq.dao.TeacherMapper;
import com.lzq.po.Grade;
import com.lzq.po.Sc;
import com.lzq.po.Teacher;
@Service
public class TeaServiceImpl implements TeaService{
	@Resource
	TeacherMapper tmapper;
	@Autowired
	ScMapper scMapper;
	@Autowired
	GradeMapper gMapper;
	@Override
	public List<Teacher> getlist(int pageNO,int size) {
		int start = (pageNO-1)*size;
		List<Teacher> list = tmapper.getlist(start,size);
		return list;
	}
	@Override
	public int getcount() {
		// TODO Auto-generated method stub
		return tmapper.getcount();
	}
	@Override
	public Teacher gettea(int id) {
		// TODO Auto-generated method stub
		return tmapper.getteacher(id);
	}
	@Override
	public List<Sc> getstu(int id) {
		// TODO Auto-generated method stub
		return scMapper.getstu(id);
	}
	@Override
	public int insert(Grade grade) {
		// TODO Auto-generated method stub
		return gMapper.insert(grade);
	}

}
