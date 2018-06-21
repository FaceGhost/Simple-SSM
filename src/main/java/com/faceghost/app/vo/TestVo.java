package com.faceghost.app.vo;

import java.io.Serializable;

/**
 * @author faceghost.com/profile/java_world
 */
public class TestVo implements Serializable{

	private String pageNum;					//页码
	private String pageSize;				//分页大小
    private Integer id;
	private String userName;
	private String addr;
	private Byte sex;
	
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Byte getSex() {
		return sex;
	}
	public void setSex(Byte sex) {
		this.sex = sex;
	}
	
	
}
