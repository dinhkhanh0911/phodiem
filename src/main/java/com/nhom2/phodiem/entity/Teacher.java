package com.nhom2.phodiem.entity;

import java.sql.Date;

public class Teacher {
	private long teacherId;
	private String teachername;
	private long userId;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;
	public Teacher(long teacherId, String teachername, long userId, String createBy, Date createDate,
			String modifiedByString, Date modifiedDate) {
		super();
		this.teacherId = teacherId;
		this.teachername = teachername;
		this.userId = userId;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedByString = modifiedByString;
		this.modifiedDate = modifiedDate;
	}
	public Teacher() {
		super();
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
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
