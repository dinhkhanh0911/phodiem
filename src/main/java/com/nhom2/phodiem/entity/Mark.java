package com.nhom2.phodiem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long markId;
	@ManyToOne
	@JoinColumn(name = "markConfigId")
	private MarkConfig markConfig;
	private float studentmark;  
	@ManyToOne
	@JoinColumn(name = "studentClassId")
	private StudentClass studentClass;
	
	
	
	/*
	 * public Mark() { } public Mark(long markId, long markconfigId, float
	 * markFinal, long studentId, long subjectId, long studentmark) { this.markId =
	 * markId; this.markconfigId = markconfigId; this.studentmark = studentmark;
	 * this.studentId = studentId; this.subjectId = subjectId; this.markconfigId =
	 * markconfigId; } public long getMarkId() { return markId; } public void
	 * setMarkId(long markId) { this.markId = markId; } public long getStudentId() {
	 * return studentId; } public void setStudentId(long studentId) { this.studentId
	 * = studentId; } public long getSubjectId() { return subjectId; } public void
	 * setSubjectId(long subjectId) { this.subjectId = subjectId; } public long
	 * getMarkconfigId() { return markconfigId; } public void setMarkconfigId(long
	 * markconfigId) { this.markconfigId = markconfigId; } public float
	 * getStudentmark() { return studentmark; } public void setStudentmark(float
	 * studentmark) { this.studentmark = studentmark; }
	 */
	
}
