package com.strongpoint.pageController;

import com.jfinal.core.Controller;
import com.strongpoint.service.NickService;

public class WorkController extends Controller{
	
	static NickService nickService = new NickService();

	public enum WorkType{
		EDITORINFO, EDITORGAMETIME, CREATETEAM
	}
	
	public class WorkInfo{
//		public  WorkType type = WorkType.EDITORINFO;
		public int type = 1;
	}
	
	public void index() throws Exception {
		setAttr("WorkInfo", new WorkInfo());
		setAttr("NickNameList", NickService.getNickNameList());
		render("Work.html");
	}
	
	public void addNickName() throws Exception {
		String nickName = getPara("nickName");
		System.out.println("addNickName: " + nickName);
		nickService.addNickName(nickName);
		redirect("/work");
	}
}
