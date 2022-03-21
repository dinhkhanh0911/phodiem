package com.nhom2.phodiem.entity;

import java.util.Date;

public class MClass {
	private long classId;
	private String classNameString;
	private String classCode;
	private int studentNumber;
	private long studentId;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;
	public MClass() {
		// TODO Auto-generated constructor stub
	}
	public MClass(long classId, String classNameString, String classCode, int studentNumber, long studentId,
			String createBy, Date createDate, String modifiedByString, Date modifiedDate) {
		super();
		this.classId = classId;
		this.classNameString = classNameString;
		this.classCode = classCode;
		this.studentNumber = studentNumber;
		this.studentId = studentId;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedByString = modifiedByString;
		this.modifiedDate = modifiedDate;
	}
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	public String getClassNameString() {
		return classNameString;
	}
	public void setClassNameString(String classNameString) {
		this.classNameString = classNameString;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
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
