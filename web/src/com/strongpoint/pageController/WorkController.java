package com.strongpoint.pageController;

import com.jfinal.core.Controller;

public class WorkController extends Controller{

	public enum WorkType{
		EDITORINFO, EDITORGAMETIME, CREATETEAM
	}
	
	public class WorkInfo{
		public  WorkType type = WorkType.EDITORINFO; 
	}
	
	public void index() {
		setAttr("WorkInfo", new WorkInfo());
		render("Work.html");
	}
}
