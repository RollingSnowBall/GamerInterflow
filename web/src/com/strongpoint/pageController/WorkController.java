package com.strongpoint.pageController;

import com.jfinal.core.Controller;
import com.strongpoint.common.model.NickName;
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
//		refreshNickNameListAndShow();
		showGameTime();
		render("Work.html");
	}
	
	public void refreshNickNameListAndShow() throws Exception {
		setAttr("WorkInfo", new WorkInfo());
		//setSessionAttr("WorkInfo", new WorkInfo());
		Integer id = getSessionAttr(CustomConstant.USER_ID);
		setAttr("NickNameList", NickService.getNickNameList(id));
	}
	
	public void showGameTime() throws Exception {
		setAttr("WorkInfo", new WorkInfo(CustomConstant.EDITOR_GAME_TIME_PAGE_INDEX));
		Integer id = getSessionAttr(CustomConstant.USER_ID);
		setAttr("NickNameList", NickService.getNickNameList(id));
	}
	
	public void showAllMsg() {
		setAttr("WorkInfo", new WorkInfo(CustomConstant.EDITOR_SHOW_All_NICKNAME_PAGE));
		setAttr("NickNameList", NickService.getAllNickNameLst());
	}
	
	public void addNickName() throws Exception {
		String nickName = getPara("nickName");
		if(nickService.findByName(nickName) != null) {
			redirect("/work");
		}
		
		System.out.println("addNickName: " + nickName);
		Integer id = getSessionAttr(CustomConstant.USER_ID);
		nickService.addNickName(nickName, id);
		redirect("/work");
	}
	
	public void deleteNickName() {
		String nickName = getPara("nickName");
		nickService.deleteNickName(nickName);
		redirect("/work");
	}
	
	public void refreshPage() throws Exception {
		Integer tp = getParaToInt("type");
		System.out.println("refreshPage: " + tp);
		//setSessionAttr("WorkInfo", new WorkInfo(tp));
		setAttr("WorkInfo", new WorkInfo(tp));
		if (tp == CustomConstant.EDITOR_NICKNAME_PAGE_INDEX) {
			refreshNickNameListAndShow();
		}else if(tp == CustomConstant.EDITOR_GAME_TIME_PAGE_INDEX) {
			showGameTime();
		}else if(tp == CustomConstant.EDITOR_SHOW_All_NICKNAME_PAGE) {
			showAllMsg();
		}
		render("Work.html");
	}
	
	public void setGameTime() {
		String nickname = getPara("nickname");
		String time = getPara("time");
		System.out.println(nickname+time);
		nickService.timeUpdate(nickname, time);
		redirect("/work");
	}
}
