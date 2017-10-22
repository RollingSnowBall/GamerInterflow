package com.strongpoint.service;

import java.util.List;
import com.strongpoint.common.model.NickName;

public class NickService {
	
	private static final NickName dao = new NickName().dao();
	
	public void addNickName(String nickName, Integer id) throws Exception {
		if(null ==nickName || nickName.isEmpty()) {
			return;
		}
		if(getNickNameList(id).size() > 10) {
			return;
		}
		NickName name = new NickName();
		name.setNickName(nickName);
		name.setUserId(id);
		name.save();
	}
	
	public static List<NickName> getNickNameList(Integer id) throws Exception {
		return NickName.dao.find("select * from nickName where userId = ?", id);
	}
}
