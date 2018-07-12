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
