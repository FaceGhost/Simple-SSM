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
