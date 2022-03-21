package com.nhom2.phodiem.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	private String studentCodeString;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;
	
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "student")
	private Set<StudentClass> studentClasses;
	
	
	/*
	 * public Student(long studentId, String studentCodeString, long userId,Long
	 * mClassId ,String createBy, Date createDate, String modifiedByString, Date
	 * modifiedDate) {
	 * 
	 * this.studentId = studentId; this.studentCodeString = studentCodeString;
	 * this.userId = userId; this.mClassId = mClassId; this.createBy = createBy;
	 * this.createDate = createDate; this.modifiedByString = modifiedByString;
	 * this.modifiedDate = modifiedDate; }
	 * 
	 * public long getmClassId() { return mClassId; }
	 * 
	 * public void setmClassId(long mClassId) { this.mClassId = mClassId; }
	 * 
	 * public Student() {
	 * 
	 * }
	 * 
	 * public long getStudentId() { return studentId; }
	 * 
	 * public void setStudentId(long studentId) { this.studentId = studentId; }
	 * 
	 * public String getStudentCodeString() { return studentCodeString; }
	 * 
	 * public void setStudentCodeString(String studentCodeString) {
	 * this.studentCodeString = studentCodeString; }
	 * 
	 * public long getUserId() { return userId; }
	 * 
	 * public void setUserId(long userId) { this.userId = userId; }
	 * 
	 * public String getCreateBy() { return createBy; }
	 * 
	 * public void setCreateBy(String createBy) { this.createBy = createBy; }
	 * 
	 * public Date getCreateDate() { return createDate; }
	 * 
	 * public void setCreateDate(Date createDate) { this.createDate = createDate; }
	 * 
	 * public String getModifiedByString() { return modifiedByString; }
	 * 
	 * public void setModifiedByString(String modifiedByString) {
	 * this.modifiedByString = modifiedByString; }
	 * 
	 * public Date getModifiedDate() { return modifiedDate; }
	 * 
	 * public void setModifiedDate(Date modifiedDate) { this.modifiedDate =
	 * modifiedDate; }
	 */

}
