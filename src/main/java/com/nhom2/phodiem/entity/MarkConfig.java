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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "markConfigs")
@Data

public class MarkConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long markConfigId;
	private String markConfigName;
	private int markConfigPrecent;
	private String createBy;
	private Date createDate;
	private String modifiedBy;
	private Date modifiedDate;
	
	@ManyToOne
	@JoinColumn(name = "subjectId")
	private Subject subject;

	public long getMarkConfigId() {
		return markConfigId;
	}

	public void setMarkConfigId(long markConfigId) {
		this.markConfigId = markConfigId;
	}

	public String getMarkConfigName() {
		return markConfigName;
	}

	public void setMarkConfigName(String markConfigName) {
		this.markConfigName = markConfigName;
	}

	public int getMarkConfigPrecent() {
		return markConfigPrecent;
	}

	public void setMarkConfigPrecent(int markConfigPrecent) {
		this.markConfigPrecent = markConfigPrecent;
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	
}
