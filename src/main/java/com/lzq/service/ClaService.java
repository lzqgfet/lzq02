package com.lzq.service;

import java.util.List;

import com.lzq.po.Classes;

public interface ClaService {
	public List<Classes> getlist(int pageNO,int size);
	public int getcount();
	public List<Classes> getslist(int id);
}
