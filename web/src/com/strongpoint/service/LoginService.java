package com.strongpoint.service;

import com.strongpoint.common.model.User;

public class LoginService {
	
	private static final User dao = new User().dao();
	
	public User findById(int id) {
		return dao.findById(id);
	}
}
