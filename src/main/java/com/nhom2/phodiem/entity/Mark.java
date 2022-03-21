package com.nhom2.phodiem.entity;

public class Mark {
	private long markId;
	private long markType;
	private float markFinal;
	private long studentId;
	private long subjectId;
	private long markconfigId;
	public Mark() {
		// TODO Auto-generated constructor stub
	}
	public Mark(long markId, long markType, float markFinal, long studentId, long subjectId, long markconfigId) {
		this.markId = markId;
		this.markType = markType;
		this.markFinal = markFinal;
		this.studentId = studentId;
		this.subjectId = subjectId;
		this.markconfigId = markconfigId;
	}
	public long getMarkId() {
		return markId;
	}
	public void setMarkId(long markId) {
		this.markId = markId;
	}
	public long getMarkType() {
		return markType;
	}
	public void setMarkType(long markType) {
		this.markType = markType;
	}
	public float getMarkFinal() {
		return markFinal;
	}
	public void setMarkFinal(float markFinal) {
		this.markFinal = markFinal;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public long getMarkconfigId() {
		return markconfigId;
	}
	public void setMarkconfigId(long markconfigId) {
		this.markconfigId = markconfigId;
	}
	
}
