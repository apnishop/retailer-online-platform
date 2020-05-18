package com.apnishop.web.data.entity;


import java.util.HashMap;

public class ResponseTransfer {
	private String code;
	private String msg;
	private Object resObj;
	private HashMap<String,String> srverr;

	
	public ResponseTransfer(String code, String msg, Object resObj, HashMap<String, String> srverr) {
		super();
		this.code = code;
		this.msg = msg;
		this.resObj = resObj;
		this.srverr = srverr;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResObj() {
		return resObj;
	}

	public void setResObj(Object resObj) {
		this.resObj = resObj;
	}

	public HashMap<String, String> getSrverr() {
		return srverr;
	}

	public void setSrverr(HashMap<String, String> srverr) {
		this.srverr = srverr;
	}

	
	
	

}
