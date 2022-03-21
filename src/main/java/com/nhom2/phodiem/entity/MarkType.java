package com.nhom2.phodiem.entity;

import java.sql.Date;

public class MarkType {
	private long markTypeId;
	private String markTypeName;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;

	public MarkType(long markTypeId, String markTypeName, String createBy, Date createDate, String modifiedByString,
			Date modifiedDate) {
		super();
		this.markTypeId = markTypeId;
		this.markTypeName = markTypeName;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedByString = modifiedByString;
		this.modifiedDate = modifiedDate;
	}

	public MarkType() {
		super();
	}

	public long getMarkTypeId() {
		return markTypeId;
	}

	public void setMarkTypeId(long markTypeId) {
		this.markTypeId = markTypeId;
	}

	public String getMarkTypeName() {
		return markTypeName;
	}

	public void setMarkTypeName(String markTypeName) {
		this.markTypeName = markTypeName;
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
