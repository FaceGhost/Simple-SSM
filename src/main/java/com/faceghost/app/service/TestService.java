package com.faceghost.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faceghost.app.annotation.ServiceErrorAnnotation;
import com.faceghost.app.dao.TestDao;
import com.faceghost.app.model.Test;
import com.faceghost.app.vo.TestVo;

@Service
public class TestService {

	/**
	 * ns
	 */
	private static final String ns = "com.faceghost.app.model.Test.";
	
	
	@Autowired
	private TestDao testDao;

	/**
	 * 保存
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Test saveBean(Test bean) throws Exception {
		testDao.save(ns, bean);
		return bean;
	}
	
	/**
	 * 根据id 删除
	 * @param id
	 * @throws Exception
	 */
	@ServiceErrorAnnotation(desc="根据ID删除Test",isSendEmail=true,sendTo="test@test.com",sendCc="test1@test.com;test2@test.com")
	public void deleteData(Integer id) throws Exception {
		testDao.deleteByPrimaryKey(ns,id);
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
		return testDao.getList(ns, "getTestPageData", searchVo);
	}

	/**
	 *  根据id获取bean
	 * @param id
	 * @return
	 */
	public Test getBeanById(Integer id) {
		return testDao.getOne(ns, id);
	}
	
	/**
	 * 更新
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public int updateBean(Test bean) throws Exception {
		return testDao.updateByPrimaryKeySelective(ns, bean);
	}
}
