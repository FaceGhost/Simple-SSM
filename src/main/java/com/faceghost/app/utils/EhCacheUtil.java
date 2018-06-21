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
package com.faceghost.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

/**
 * ehcache 缓存工具类
 * 
 * @author faceghost.com/profile/java_world
 */
@Component
public class EhCacheUtil {

	@Autowired()
	private EhCacheCacheManager ehCacheCacheManager;
	
	/**
	 * classpath 下 ehcache.xml 
	 */
	private static final String defautCache = "appDefault";
	
	public Cache getDefault() {
		return  ehCacheCacheManager.getCache(defautCache);
	}
	
}
