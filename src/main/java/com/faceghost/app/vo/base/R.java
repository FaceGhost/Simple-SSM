package com.faceghost.app.vo.base;

import java.io.Serializable;

/**
 * @author faceghost.com/profile/java_world
 */
public class R  implements Serializable{

	private boolean success;
	private String msg;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
