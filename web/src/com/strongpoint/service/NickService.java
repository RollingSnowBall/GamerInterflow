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
	
	public void timeUpdate(String nickName, String time) {
		NickName name = new NickName();
		name.setNickName(nickName);
		name.setTime(time);
		name.update();
	}
	
	public static List<NickName> getNickNameList(Integer id) throws Exception {
		return NickName.dao.find("select * from nickName where userId = ?", id);
	}
	
	public NickName findByName(String name) {
		return dao.findById("name");
	}
	
	public static List<NickName> getAllNickNameLst(){
		return NickName.dao.find("select * from nickName");
	}
	
	public void deleteNickName(String name) {
		NickName nickName = new NickName();
		System.out.println(name);
		nickName.setNickName(name);
		nickName.delete();
	}
}
