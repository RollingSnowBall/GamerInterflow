package com.strongpoint.manager;

import java.util.List;

import com.strongpoint.common.model.NickName;
import com.strongpoint.common.model.User;

public class UserManager extends Singleton {
	
	User selfInfo = new User();
	
	List<NickName> nickNameList;
	
	public void setSelfInfo(int id, String pass) {
		selfInfo.setId(id);
		selfInfo.setPass(pass);
	}
	
	public User getSelfInfo() {
		return selfInfo;
	}
}
