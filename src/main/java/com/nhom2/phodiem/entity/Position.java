package com.nhom2.phodiem.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "positions")
@Data
public class Position {
	public long getPositionId() {
		return positionId;
	}

	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long positionId;
	private String positionName;
	private String positionCode;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;
	
	@OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
	private Set<User> users;

	/*
	 * public Position() { // TODO Auto-generated constructor stub }
	 * 
	 * public Position(long positionId, String positionName, String positionCode,
	 * String createBy, Date createDate, String modifiedByString, Date modifiedDate)
	 * { super(); this.positionId = positionId; this.positionName = positionName;
	 * this.positionCode = positionCode; this.createBy = createBy; this.createDate =
	 * createDate; this.modifiedByString = modifiedByString; this.modifiedDate =
	 * modifiedDate; }
	 * 
	 * public long getPositionId() { return positionId; }
	 * 
	 * public void setPositionId(long positionId) { this.positionId = positionId; }
	 * 
	 * public String getPositionName() { return positionName; }
	 * 
	 * public void setPositionName(String positionName) { this.positionName =
	 * positionName; }
	 * 
	 * public String getPositionCode() { return positionCode; }
	 * 
	 * public void setPositionCode(String positionCode) { this.positionCode =
	 * positionCode; }
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
