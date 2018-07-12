package com.faceghost.app.model;

import com.faceghost.app.model.base.BaseModel;

/**
 * @author faceghost.com/profile/java_world
 */
public class Test extends BaseModel {
	
    private Integer id;

    private String userName;

    private String addr;

    private Byte sex;

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }
}