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
		public int type = CustomConstant.EDITOR_NICKNAME_PAGE_INDEX;
		public WorkInfo(Integer type) {
			this.type = type; 
		}
		public WorkInfo( ) { 
		}
	}
	
	public void index() throws Exception {
		refreshNickNameListAndShow();
	}
	
	public void refreshNickNameListAndShow() throws Exception {
		setAttr("WorkInfo", new WorkInfo());
		//setSessionAttr("WorkInfo", new WorkInfo());
		Integer id = getSessionAttr(CustomConstant.USER_ID);
		setAttr("NickNameList", NickService.getNickNameList(id));
		render("Work.html");
	}
	
	public void addNickName() throws Exception {
		String nickName = getPara("nickName");
		System.out.println("addNickName: " + nickName);
		Integer id = getSessionAttr(CustomConstant.USER_ID);
		nickService.addNickName(nickName, id);
		redirect("/work");
	}
	
	public void refreshPage() throws Exception {
		Integer tp = getParaToInt("type");
		System.out.println("refreshPage: " + tp);
		//setSessionAttr("WorkInfo", new WorkInfo(tp));
		setAttr("WorkInfo", new WorkInfo(tp));
		if (tp == CustomConstant.EDITOR_NICKNAME_PAGE_INDEX) {
			refreshNickNameListAndShow();
		}
		render("Work.html");
	}
}
