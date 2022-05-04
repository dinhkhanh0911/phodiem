package com.nhom2.phodiem.entity;

public class PhoDiemException extends Exception {
	public PhoDiemException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
	public PhoDiemException() {
		
	}
	@Override
    public String getMessage() {
        return "Lỗi nhập vào một tuổi: " + super.getMessage();
    } 
}
