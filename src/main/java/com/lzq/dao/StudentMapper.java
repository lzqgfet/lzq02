package com.lzq.dao;

import com.lzq.po.Login;
import com.lzq.po.Student;
import com.lzq.po.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    int getcount();
    List<Student> getlist(@Param("start") int start,@Param("size") int size);
    void delmany(String s);
    Student getStu(@Param("id") int id);
    int delestu(@Param("rid") int rid);
    void dellogins(String s);
    int getclaid(int id);
    
    
}