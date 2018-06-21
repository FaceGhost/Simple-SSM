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
package com.faceghost.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faceghost.app.model.Test;
import com.faceghost.app.service.TestService;
import com.faceghost.app.vo.TestVo;
import com.faceghost.app.vo.base.PageVo;
import com.faceghost.app.vo.base.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 请求接受 ~/test 
 * @author faceghost.com/profile/java_world
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	
	/**
	 * 默认请求地址， ~/test
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param searchVo
	 * @return
	 */
	@RequestMapping("")
	public String Index(TestVo searchVo,HttpServletRequest request) {
		//分页bean
		PageVo pageList = new PageVo();
		int pageNum  = 1;
		//默认分页大小
		int pageSize  = 10;
		try {
			try {
				pageNum = Integer.valueOf(searchVo.getPageNum());
				//pageNum 应 > 1
				if(pageNum < 1) {
					pageNum = 1;
				}
			} catch (Exception e) {
				//
			}
			
			
			try {
				pageSize = Integer.valueOf(searchVo.getPageSize());
				//pageNum 应 > 1
				if(pageSize < 1) {
					pageSize = 5;
				}
			} catch (Exception e) {
				//
			}
			
			
			PageHelper.startPage(pageNum, pageSize);
			List<TestVo> list = testService.getTestPageData(searchVo);
			PageInfo<TestVo> pageInfo = new PageInfo<TestVo>(list);
			
			
			//设置list,和total
			pageList.setList(pageInfo.getList());
			pageList.setTotal(pageInfo.getTotal());
			pageList.setPageNo(pageNum);
			pageList.setTotalPage(pageInfo.getPages());
			
			
			request.setAttribute("vo", pageList);
			request.setAttribute("searchVo", searchVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	
	/**
	 * 保存
	 * @param voBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addData")
	public String saveTest(TestVo voBean,HttpServletRequest request) throws Exception {
		R r = new R();
		r.setSuccess(Boolean.FALSE);
		if(voBean.getUserName() == null || voBean.getUserName().trim().length() == 0) {
			r.setMsg("UserName必填");
			request.setAttribute("err", r);
			return "/addData";
		}
		Test bean = new Test();
		bean.setUserName(voBean.getUserName().trim());
		bean.setSex(voBean.getSex());
		bean.setAddr(voBean.getAddr());
		testService.saveBean(bean);
		return "redirect:/test";
	}
	
	/**
	 * 删除
	 * 
	 * @param voBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteData")
	public String deleteData(TestVo voBean,HttpServletRequest request) throws Exception {
		if(voBean.getId() != null) {
			testService.deleteData(voBean.getId());
		}
		
		return "redirect:/test";
	}
	
	
	/**
	 * 更新前获取数据
	 * 
	 * @param voBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateDataPre")
	public String updateDataPre(TestVo voBean,HttpServletRequest request) throws Exception {
		if(voBean.getId() != null) {
			Test bean = testService.getBeanById(voBean.getId());
			request.setAttribute("bean", bean);
			return "/updateData";
		}
		
		return "redirect:/test";
	}
	
	
	/**
	 * 更新
	 * @param voBean
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateData")
	public String updateData(TestVo voBean,HttpServletRequest request) throws Exception {
		R r = new R();
		r.setSuccess(Boolean.FALSE);
		if(voBean.getId() == null) {
			return "redirect:/test";
		};
		
		if(voBean.getUserName() == null || voBean.getUserName().trim().length() == 0) {
			r.setMsg("UserName必填");
			request.setAttribute("err", r);
			return "/updateData";
		}
		Test bean = new Test();
		bean.setId(voBean.getId());
		bean.setUserName(voBean.getUserName().trim());
		bean.setSex(voBean.getSex());
		bean.setAddr(voBean.getAddr());
		int rows = testService.updateBean(bean);
		if(rows <= 0 ) {
			r.setMsg("更新失败，请重试~");
			request.setAttribute("err", r);
		}
		

		/**
		 * 更新成功
		 */
		return "redirect:/test";
			
	}
}
