package com.lzq.dao;

import com.lzq.po.CtcExample;
import com.lzq.po.CtcKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtcMapper {
    long countByExample(CtcExample example);

    int deleteByExample(CtcExample example);

    int deleteByPrimaryKey(CtcKey key);

    int insert(CtcKey record);

    int insertSelective(CtcKey record);

    List<CtcKey> selectByExample(CtcExample example);

    int updateByExampleSelective(@Param("record") CtcKey record, @Param("example") CtcExample example);

    int updateByExample(@Param("record") CtcKey record, @Param("example") CtcExample example);
    int adds(List<CtcKey> list);
    List<CtcKey> getclclist(@Param("claid") int claid);
    int gettid(@Param("claid") int claid,@Param("couid") int couid);
}