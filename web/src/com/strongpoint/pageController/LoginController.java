package com.strongpoint.pageController;

import com.jfinal.core.Controller;
import com.strongpoint.common.model.User;
import com.strongpoint.service.LoginService;

public class LoginController extends Controller  {
	
	static LoginService service = new LoginService();
	
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
		String msg = "账号密码错误重新输入";
//		getModel(User.class)
		System.out.println("++++++++++++++++");
		Integer id = getParaToInt("id");
		service.findById(id);
		setAttr("LoginWarn", msg);
		render("login.html");
	}
}