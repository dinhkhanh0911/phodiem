package com.nhom2.phodiem.entity;

import java.sql.Date;

public class Semester {
private long semesterId;
private String semesterCode;
private String semesterName;
private String createBy;
private Date createDate;
private String modifiedByString;
private Date modifiedDate;

public Semester() {

}
public Semester(long semesterId, String semesterCode, String semesterName, String createBy, Date createDate,
		String modifiedByString, Date modifiedDate) {

	this.semesterId = semesterId;
	this.semesterCode = semesterCode;
	this.semesterName = semesterName;
	this.createBy = createBy;
	this.createDate = createDate;
	this.modifiedByString = modifiedByString;
	this.modifiedDate = modifiedDate;
}
public long getSemesterId() {
	return semesterId;
}
public void setSemesterId(long semesterId) {
	this.semesterId = semesterId;
}
public String getSemesterCode() {
	return semesterCode;
}
public void setSemesterCode(String semesterCode) {
	this.semesterCode = semesterCode;
}
public String getSemesterName() {
	return semesterName;
}
public void setSemesterName(String semesterName) {
	this.semesterName = semesterName;
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
