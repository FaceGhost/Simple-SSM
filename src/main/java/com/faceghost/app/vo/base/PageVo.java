package com.faceghost.app.vo.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author faceghost.com/profile/java_world
 */
public class PageVo  implements Serializable {

	private long total;
	private List list;
	private int pageNo;
	private int totalPage;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
	
}
