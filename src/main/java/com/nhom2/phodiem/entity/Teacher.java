package com.nhom2.phodiem.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teachers")
@Data
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teacherId;
	private String teachername;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private Set<MClass> mClasses;
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
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	public Set<MClass> getmClasses() {
//		return mClasses;
//	}
//	public void setmClasses(Set<MClass> mClasses) {
//		this.mClasses = mClasses;
//	}
	
	
	
}
