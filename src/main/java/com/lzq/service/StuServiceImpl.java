package com.lzq.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzq.dao.ClassesMapper;
import com.lzq.dao.CtcMapper;
import com.lzq.dao.GradeMapper;
import com.lzq.dao.LoginMapper;
import com.lzq.dao.ScMapper;
import com.lzq.dao.StudentMapper;
import com.lzq.po.Classes;
import com.lzq.po.CtcKey;
import com.lzq.po.Grade;
import com.lzq.po.Login;
import com.lzq.po.Sc;
import com.lzq.po.StuExte;
import com.lzq.po.Student;
@Service
public class StuServiceImpl implements StuService{
	@Resource
	StudentMapper smapper;
	@Resource
	ClassesMapper cmapper;
	@Autowired
	LoginMapper lmapper;
	@Resource
	CtcMapper ctc;
	@Resource
	ScMapper sc;
	@Autowired
	GradeMapper gMapper;
	@Override
	public List<Student> getlist(int pageNO,int size) {
		int start = (pageNO-1)*size;
		List<Student> list = smapper.getlist(start,size);
		return list;
	}
	@Override
	public int getcount() {
		return smapper.getcount();
	}
	@Override
	public void StuSandA(StuExte stu) {
		Student student=new Student();
		student.setName(stu.getName());
		student.setAddress(stu.getAddress());
		student.setSex(stu.getSex());
		student.setTel(stu.getTel());
		student.setClassid(stu.getClasses().getId());
		smapper.insert(student);
		Login login=new Login();
		login.setLoginname(stu.getLoginname());
		login.setPassword(stu.getPassword());
		login.setRid(student.getId());
		login.setRole(3);
		lmapper.insert(login);
		
	}
	@Override
	public List<Classes> getclist() {
		List<Classes> list = cmapper.getclist();
		return list;
	}
	@Override
	public int deletestu(int id) {
		int n = smapper.deleteByPrimaryKey(id);
		smapper.delestu(id);
		return n;
	}
	@Override
	public Student getstu(int id) {
		Student stu = smapper.getStu(id);
		return stu;
	}
	@Override
	public void deleteMany(String s) {
		smapper.delmany(s);
		smapper.dellogins(s);
	}
	@Override
	public void update(Student stu) {
		stu.setClassid(stu.getClasses().getId());
		smapper.updateByPrimaryKey(stu);
		
		Login login = new Login();
		login.setLoginname(stu.getLogin().getLoginname());
		login.setPassword(stu.getLogin().getPassword());
		login.setId(stu.getLogin().getId());
		lmapper.updateByRid(login);
	}
	@Override
	public List<CtcKey> getclclist(int classid) {
		// TODO Auto-generated method stub
		return ctc.getclclist(classid);
	}
	@Override
	public int getclaid(Login login) {
		int id=login.getRid();
		return smapper.getclaid(id);
	}
	@Override
	public void selcou(int claid, int[] ids, int sid) {
		/*// TODO Auto-generated method stub
		for(int id:ids){
			int tid = ctc.gettid(claid, id);
			sc.add(sid, tid, claid);
		}
	*/
		
	}
	@Override
	public List<Sc> getMyCourse(int id) {
		// TODO Auto-generated method stub
		return sc.getMyCourse(id);
	}
	@Override
	public List<Grade> getGrade(int id) {
		// TODO Auto-generated method stub
		return gMapper.getgrade(id);
	}

}
