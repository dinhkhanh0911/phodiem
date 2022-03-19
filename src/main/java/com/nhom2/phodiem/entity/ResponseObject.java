package com.nhom2.phodiem.entity;

public class ResponseObject {
	public ResponseObject() {
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseObject(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	private int code;
	private String message;
	private Object data;
	
	
}
