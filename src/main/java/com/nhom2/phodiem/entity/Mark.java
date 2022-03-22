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
	public long getMarkId() {
		return markId;
	}
	public void setMarkId(long markId) {
		this.markId = markId;
	}
//	public MarkConfig getMarkConfig() {
//		return markConfig;
//	}
//	public void setMarkConfig(MarkConfig markConfig) {
//		this.markConfig = markConfig;
//	}
	public float getStudentmark() {
		return studentmark;
	}
	public void setStudentmark(float studentmark) {
		this.studentmark = studentmark;
	}
//	public StudentClass getStudentClass() {
//		return studentClass;
//	}
//	public void setStudentClass(StudentClass studentClass) {
//		this.studentClass = studentClass;
//	}
	
	
	
}
