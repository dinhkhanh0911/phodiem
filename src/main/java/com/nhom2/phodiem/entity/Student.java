package com.nhom2.phodiem.entity;

import java.sql.Date;

public class Student {
	private long studentId;
	private String studentCodeString;
	private long userId;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;

	public Student(long studentId, String studentCodeString, long userId, String createBy, Date createDate,
			String modifiedByString, Date modifiedDate) {

		this.studentId = studentId;
		this.studentCodeString = studentCodeString;
		this.userId = userId;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedByString = modifiedByString;
		this.modifiedDate = modifiedDate;
	}

	public Student() {

	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentCodeString() {
		return studentCodeString;
	}

	public void setStudentCodeString(String studentCodeString) {
		this.studentCodeString = studentCodeString;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getModifiedByString() {
		return modifiedByString;
	}

	public void setModifiedByString(String modifiedByString) {
		this.modifiedByString = modifiedByString;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
