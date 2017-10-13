package com.strongpoint.pageController;

import com.jfinal.core.Controller;
import com.strongpoint.common.model.User;

public class LoginController extends Controller  {
	
//	static 
	
	public void index() {
		render("login.html");
	}
	
	public void addUser() {
		Integer id = getParaToInt("id");
		String pass = getPara("pass");
//		getModel(User.class)
		System.out.println("LoginController addUser : id : " + id + " pass : " + pass);
		
		(new User(id, pass)).save();
		
		render("login.html");
	}
	
	public void loginUser() {
//		getModel(User.class)
		System.out.println("++++++++++++++++");
	}
}