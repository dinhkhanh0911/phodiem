package com.nhom2.phodiem.entity;

import java.sql.Date;

public class Subject {
	private long subjectId;
	private String subjectCode;
	private String subjectName;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;

	public Subject(long subjectId, String subjectCode, String subjectName, String createBy, Date createDate,
			String modifiedByString, Date modifiedDate) {

		this.subjectId = subjectId;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedByString = modifiedByString;
		this.modifiedDate = modifiedDate;
	}

	public Subject() {

	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
