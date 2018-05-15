package com.faceghost.app.dao;

import java.util.List;

import com.faceghost.app.model.Test;
import com.faceghost.app.vo.TestVo;

public interface TestMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

     
    //-- above auto gen
    
    List<TestVo> getTestPageData(TestVo searchVo);
    
    
}