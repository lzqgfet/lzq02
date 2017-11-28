package com.lzq.dao;

import com.lzq.po.Sc;
import com.lzq.po.ScExample;
import com.lzq.po.ScKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScMapper {
    long countByExample(ScExample example);

    int deleteByExample(ScExample example);

    int deleteByPrimaryKey(ScKey key);

    int insert(Sc record);

    int insertSelective(Sc record);

    List<Sc> selectByExample(ScExample example);

    Sc selectByPrimaryKey(ScKey key);

    int updateByExampleSelective(@Param("record") Sc record, @Param("example") ScExample example);

    int updateByExample(@Param("record") Sc record, @Param("example") ScExample example);

    int updateByPrimaryKeySelective(Sc record);

    int updateByPrimaryKey(Sc record);
    void add(@Param("sid") int sid,@Param("tid") int tid,@Param("cid") int cid);
    void adds(List<Sc> sclist);
    List<Sc> getMyCourse(@Param("id") int id);
    List<Sc> getstu(@Param("id") int id);
}