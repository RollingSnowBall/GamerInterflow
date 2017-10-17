package com.strongpoint.pageController;

import com.jfinal.core.Controller;
import com.strongpoint.common.model.User;
import com.strongpoint.manager.Singleton;
import com.strongpoint.manager.UserManager;
import com.strongpoint.service.LoginService;

public class LoginController extends Controller  {
	
	static LoginService service = new LoginService();
	
	public void index() {
		render("login.html");
	}
	
	public void addUser() throws Exception {
		Integer id = getParaToInt("id");
		String pass = getPara("pass");
		System.out.println("LoginController addUser : id : " + id + " pass : " + pass);
		
		User self = service.findById(id);
		if(self != null) {
			String msg = "用户已存在";
			service.findById(id);
			setAttr("LoginWarn", msg);
			render("Login.html");
			return;
		}
		((UserManager)Singleton.getInstance(UserManager.class)).setSelfInfo(id, pass);
		((UserManager)Singleton.getInstance(UserManager.class)).getSelfInfo().save();
;		redirect("/work");
	}
	
	public void loginUser() throws Exception {
		Integer id = getParaToInt("id");
		String pass = getPara("pass");
		User selfInfo = service.findById(id);
		if(selfInfo != null) {
			if (selfInfo.getPass().equals(pass)) {
				((UserManager)Singleton.getInstance(UserManager.class)).setSelfInfo(id, pass);
				redirect("/work");
				return;
			}
		}
		String msg = "账号密码错误重新输入";
		setAttr("LoginWarn", msg);
		render("Login.html");
	}
}