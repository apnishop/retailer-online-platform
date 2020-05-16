package com.apnishop.web.data.entity;


import java.util.HashMap;

public class ResponseTransfer {
	private String code;
	private Object msg;
	private HashMap<String,String> srverr;

	
	public ResponseTransfer(String code, Object msg, HashMap<String, String> srverr) {
		super();
		this.code = code;
		this.msg = msg;
		this.srverr = srverr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	public HashMap<String, String> getSrverr() {
		return srverr;
	}

	public void setSrverr(HashMap<String, String> srverr) {
		this.srverr = srverr;
	}

	
	
	

}
