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
package com.faceghost.app.dao.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;



/**
 * 
 * @author faceghost.com/profile/java_world
 * 
 * 操作mybatis映射文件中parameterType="map"
 *
 */
public class SqlParams implements Serializable{

	private  Map<String, Object> params = new HashMap<String, Object>();
	
	private SqlParams(){}
	
	/**
	 * 初始化  返回this,方便链式操作
	 * @return this
	 */
	public static SqlParams init(){
		return  new SqlParams();
	}
	
	/**
	 * 添加参数  返回this,方便链式操作
	 * @param key
	 * @param val
	 * @return this
	 */
	public SqlParams addParam(String key,Object val){
		params.put(key, val);
		return this;
	}
	
	/**
	 * 得到参数 返回Map
	 * @return Map
	 */
	public  Map<String, Object> getParams(){ 
		return params;
	}
}
