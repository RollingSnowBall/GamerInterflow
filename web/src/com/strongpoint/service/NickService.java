package com.strongpoint.service;

import java.util.List;

import com.strongpoint.common.model.NickName;
import com.strongpoint.manager.Singleton;
import com.strongpoint.manager.UserManager;

public class NickService {
	
	private static final NickName dao = new NickName().dao();
	
	public void addNickName(String nickName) throws Exception {
		if(null ==nickName || nickName.isEmpty()) {
			return;
		}
		if(getNickNameList().size() > 10) {
			return;
		}
		NickName name = new NickName();
		name.setNickName(nickName);
		Integer id = ((UserManager)Singleton.getInstance(UserManager.class)).getSelfInfo().getId();
		name.setUserId(id);
		name.save();
	}
	
	public static List<NickName> getNickNameList() throws Exception {
		Integer id = ((UserManager)Singleton.getInstance(UserManager.class)).getSelfInfo().getId();
		return NickName.dao.find("select * from nickName where userId = ?", id);
	}
}
