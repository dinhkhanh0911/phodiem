package com.nhom2.phodiem.entity;

import java.sql.Date;

public class MarkConfig {
	private	long markConfig;
	private String markConfigName;
	private int markConfigPrecent;
	private String createBy;
	private Date createDate;
	private String modifiedBy;
	private Date modifiedDate;
	
	
	
	public MarkConfig() {
		
	}
	public MarkConfig(long markConfig, String markConfigName, int markConfigPrecent, String createBy, Date createDate,
			String modifiedBy, Date modifiedDate) {
		
		this.markConfig = markConfig;
		this.markConfigName = markConfigName;
		this.markConfigPrecent = markConfigPrecent;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}
	public long getMarkConfig() {
		return markConfig;
	}
	public void setMarkConfig(long markConfig) {
		this.markConfig = markConfig;
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
	
}
