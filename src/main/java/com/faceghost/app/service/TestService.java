package com.faceghost.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faceghost.app.dao.TestMapper;
import com.faceghost.app.model.Test;
import com.faceghost.app.vo.TestVo;

@Service
public class TestService {

	@Autowired
	private TestMapper testMapper;

	/**
	 * 保存
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Test saveBean(Test bean) throws Exception {
		testMapper.insert(bean);
		return bean;
	}
	
	/**
	 * 根据id 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteData(Integer id) throws Exception {
		testMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * test 分页数据
	 * @param searchVo
	 * @return
	 */
	public List<TestVo> getTestPageData(TestVo searchVo) throws Exception {
		/**
		 * 其他操作
		 */
		return testMapper.getTestPageData(searchVo);
	}

	/**
	 *  根据id获取bean
	 * @param id
	 * @return
	 */
	public Test getBeanById(Integer id) {
		return testMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 更新
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public int updateBean(Test bean) throws Exception {
		return testMapper.updateByPrimaryKey(bean);
	}
}
