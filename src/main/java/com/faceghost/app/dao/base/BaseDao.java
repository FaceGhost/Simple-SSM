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
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.faceghost.app.model.base.BaseModel;


/**
 * 
 * @author faceghost.com/profile/java_world  
 * @author faceghost.com/profile/xingfu2017 
 *  
 */
@Repository
public class BaseDao{

	@Resource
	public SqlSessionTemplate sqlTemplate;
	
	
	/**
	 * 传入一个Model对象并保存，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param superModel 实体类对象
	 * @return int 保存对象的条数
	 */
	public int save(String ns,String sqlId, BaseModel superModel ){
		return sqlTemplate.insert(ns + sqlId, superModel);
	}
	
	/**
	 * 
	 * 传入一个Model对象并保存，执行对应mapper.xml下的ID = "insert" 方法，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param superModel 实体类对象
	 * @return int 保存对象的条数
	 */
	public int save(String ns,BaseModel superModel ){
		return this.save(ns,"insert", superModel);
	}
	
	/**
	 * 
	 * 传入一个Model对象并保存，执行对应mapper.xml下的ID = "insertSelective" 方法，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param superModel 实体类对象
	 * @return int 保存对象的条数
	 */
	public int saveSelective(String ns,BaseModel superModel ){
		return this.save(ns,"insertSelective", superModel);
	}
	
	/**
	 * 传入一个SqlParams保存
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param parmas SqlParams 参数对象
	 * @return int 保存对象的条数
	 */
	public int save(String ns,String sqlId, SqlParams params){
		return sqlTemplate.insert(ns + sqlId, params.getParams());
	}
	
	/**
	 * 批量保存
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param list
	 * @return
	 */
	public int saveBatch(String ns,String sqlId, List list){
		return sqlTemplate.insert(ns + sqlId, list);
	}
	
	/**
	 * 传入一个Model对象并更新，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param superModel 实体类对象
	 * @return int 更新对象的条数
	 */
	public int update(String ns,String sqlId, BaseModel superModel ){
		return sqlTemplate.update(ns + sqlId, superModel);
	}
	
	/**
	 * 传入一个Model对象并更新，执行对应mapper.xml下的ID = "updateByPrimaryKey" 方法，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param superModel 实体类对象
	 * @return int 更新对象的条数
	 */
	public int updateByPrimaryKey(String ns,BaseModel superModel ){
		return this.update(ns ,"updateByPrimaryKey", superModel);
	}
	
	/**
	 * 传入一个Model对象并更新，执行对应mapper.xml下的ID = "updateByPrimaryKeySelective" 方法，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param superModel 实体类对象
	 * @return int 更新对象的条数
	 */
	public int updateByPrimaryKeySelective(String ns,BaseModel superModel ){
		return this.update(ns,"updateByPrimaryKeySelective", superModel);
	}
	
	/**
	 * 传入一个SqlParams更新
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param params SqlParams 参数对象
	 * @return 更新对象的条数 
	 */
	public int update(String ns,String sqlId, SqlParams params ){
		return sqlTemplate.update(ns + sqlId,  params.getParams());
	}
	
	/**
	 * 批量更新
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param list
	 * @return
	 */
	public int updateBatch(String ns,String sqlId,List list){
		return sqlTemplate.update(ns + sqlId, list);
	}
	
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值删除对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param key mybatis映射文件中parameterType="int||string..."中的值
	 * @return int 删除对象的条数
	 */
	public int delete(String ns,String sqlId, Serializable key ){
		return sqlTemplate.delete(ns + sqlId, key);
	}
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值删除对象，执行对应mapper.xml下的ID = "deleteByPrimaryKey" 方法
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param key mybatis映射文件中parameterType="int||string..."中的值
	 * @return int 删除对象的条数
	 */
	public int deleteByPrimaryKey(String ns, Serializable key ){
		return this.delete(ns,"deleteByPrimaryKey", key);
	}
	
	/**
	 * 传入一个Model对象删除，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param superModel 实体类对象
	 * @return int 删除对象的条数
	 */
	public int delete(String ns,String sqlId, BaseModel superModel ){
		return sqlTemplate.delete(ns + sqlId, superModel);
	}
	
	/**
	 * 传入一个SqlParams执行删除
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param params SqlParams 参数对象
	 * @return 删除对象的条数 
	 */
	public int delete(String ns,String sqlId, SqlParams params){
		return sqlTemplate.delete(ns + sqlId,  params.getParams());
	}
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值查询一个对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param key mybatis映射文件中parameterType="int||string..."中的值
	 * @return 实体类对象
	 */
	public <T> T getOne(String ns, String  sqlId,Serializable key){
		return sqlTemplate.selectOne(ns + sqlId, key);
	}
	
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值查询一个对象，执行对应mapper.xml下的ID = "selectByPrimaryKey" 方法
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param key mybatis映射文件中parameterType="int||string..."中的值
	 * @return 实体类对象
	 */
	public <T> T getOne(String ns,Serializable key){
		return this.getOne(ns,"selectByPrimaryKey", key);
	}
	
	/**
	 * 传入一个Model对象查询这个对象，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间,如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param superModel  实体类对象
	 * @return 实体类对象
	 */
	public <T> T getOne(String ns, String  sqlId,BaseModel superModel){
		
		return sqlTemplate.selectOne(ns + sqlId, superModel);
	}
	
	/**
	 * 传入一个SqlParams查询一个Model对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param params  SqlParams 参数对象
	 * @return 实体类对象
	 */
	public <T> T getOne(String ns,String  sqlId,SqlParams params){
		
		return sqlTemplate.selectOne(ns + sqlId,  params.getParams());
	}
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值 查询,如：count(*),sum(*)等
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param key  key mybatis映射文件中parameterType="int||string..."中的值
	 * @return long
	 */
	public long getCount(String ns,String sqlId,Serializable key){
		Long count =  sqlTemplate.selectOne(ns + sqlId, key);
		return count == null ? 0 : count;
	}
	
	/**
	 * 传入一个Model对象查询,如：count(*),sum(*)等，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param superModel 实体类对象
	 * @return long
	 */
	public long getCount(String ns,String sqlId,BaseModel superModel){
		Long count =  sqlTemplate.selectOne(ns + sqlId, superModel);
		return count == null ? 0 : count;
	}
	
	/**
	 * 传入一个SqlParams查询,如：count(*),sum(*)等
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param params SqlParams 参数对象
	 * @return long
	 */
	public long getCount(String ns,String sqlId,SqlParams params){
		Long count =  sqlTemplate.selectOne(ns + sqlId,  params.getParams());
		return count == null ? 0 : count;
	}
	
	/**
	 * 根据mybatis映射文件中parameterType="int||string..."中的值 查询实体类对象集合
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param key mybatis映射文件中parameterType="int||string..."中的值
	 * @return 实体类对象集合
	 */
	public <T> List<T> getList(String ns, String  sqlId,Serializable key){
		return sqlTemplate.selectList(ns + sqlId, key);
	}
	
	/**
	 * 传入一个Model对象查询实体类对象集合，superModel是所有Model的父类，所有的model请继承BaseModel，使用时传入子类对象
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param superModel  实体类对象
	 * @return 实体类对象集合
	 */
	public <T> List<T> getList(String ns, String  sqlId,BaseModel superModel){
		return sqlTemplate.selectList(ns + sqlId, superModel);
	}
	
	/**
	 * 传入一个SqlParams查询实体类对象集合
	 * @param ns nameSpace 命名空间  ， 即对应mapper.xml下的namespace ，如没有传""
	 * @param sqlId 即对应mapper.xml下的id
	 * @param params  SqlParams 参数对象， 可为null
	 * @return 实体类对象集合
	 */
	public <T> List<T> getList(String ns,String  sqlId,SqlParams params){
		if (null==params) {
			return sqlTemplate.selectList(ns + sqlId);
		}
		return sqlTemplate.selectList(ns + sqlId,  params.getParams());
	}
	
}
