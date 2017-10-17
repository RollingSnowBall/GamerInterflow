package com.strongpoint.manager;

import com.strongpoint.common.model.User;

public class UserManager extends Singleton {
	
	User selfInfo = new User();
	
	public void setSelfInfo(int id, String pass) {
		selfInfo.setId(id);
		selfInfo.setPass(pass);
	}
	
	public User getSelfInfo() {
		return selfInfo;
	}
}
