package com.lzq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzq.dao.ClassesMapper;
import com.lzq.po.Classes;
@Service
public class ClaServiceImpl implements ClaService {
	@Autowired
	ClassesMapper cMapper;
	@Override
	public List<Classes> getlist(int pageNO,int size) {
		// TODO Auto-generated method stub
		int start=(pageNO-1)*size;
		return cMapper.getlist(start,size);
	}
	@Override
	public int getcount() {
		// TODO Auto-generated method stub
		return cMapper.getcount();
	}
	@Override
	public List<Classes> getslist(int id) {
		// TODO Auto-generated method stub
		return cMapper.getslist(id);
	}

}
