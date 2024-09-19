package com.sinctrlaltf4.action;

import com.opensymphony.xwork2.ActionSupport;

public class EntrarAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
