package com.lzq.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzq.dao.CourseMapper;
import com.lzq.dao.CtcMapper;
import com.lzq.dao.TeacherMapper;
import com.lzq.po.CouExte;
import com.lzq.po.Course;
import com.lzq.po.CtcKey;
import com.lzq.po.Teacher;
@Service
public class CouServiceImpl implements CouService{
	@Autowired
	CourseMapper cMapper;
	@Autowired
	TeacherMapper tMapper;
	@Autowired
	CtcMapper ctc;
	@Override
	public List<Course> getlist(int pageNO,int size) {
		// TODO Auto-generated method stub
		int start=(pageNO-1)*size;
		return cMapper.getlist(start, size);
	}

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return tMapper.getAll();
	}
	@Override
	public int getcount(){
		int n= cMapper.getcount();
		return n;
	}

	@Override
	public CouExte getcou(int id) {
		// TODO Auto-generated method stub
		return cMapper.selectByPrimaryKey(id);
	}

	@Override
	public void setct(CouExte couExte) {
		// TODO Auto-generated method stub
	
		List<CtcKey> list=new ArrayList<CtcKey>();
		List<Integer> claids = couExte.getClaids();
		for(Integer claid:claids){
			CtcKey ctcKey=new CtcKey();
			ctcKey.setClaid(claid);
			ctcKey.setCouid(couExte.getId());
			ctcKey.setTid(couExte.getTid());
			list.add(ctcKey);
		}
		ctc.adds(list);
		
	}

}
