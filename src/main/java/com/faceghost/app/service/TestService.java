/**
 *    Copyright 2017-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.faceghost.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faceghost.app.dao.TestMapper;
import com.faceghost.app.model.Test;
import com.faceghost.app.vo.TestVo;


/**
 * @author faceghost.com/profile/java_world
 */
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
