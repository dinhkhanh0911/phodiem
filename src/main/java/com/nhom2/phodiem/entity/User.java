package com.nhom2.phodiem.entity;

import java.sql.Date;

public class User {
	private long userId;
	private String userName;
	private String passWord;
	private String fullName;
	private String phoneNumber;
	private String email;
	private String address;
	private int gender;
	private Date dateOfBrith;
	private String identityNumber;
	private String identityPlace;
	private Date identityDate;
	private String positionName;
	private long positonId;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String userName, String passWord, String fullName, String phoneNumber, String email,
			String address, int gender, Date dateOfBrith, String identityNumber, String identityPlace,
			Date identityDate, String positionName, long positonId, String createBy, Date createDate,
			String modifiedByString, Date modifiedDate) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.dateOfBrith = dateOfBrith;
		this.identityNumber = identityNumber;
		this.identityPlace = identityPlace;
		this.identityDate = identityDate;
		this.positionName = positionName;
		this.positonId = positonId;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedByString = modifiedByString;
		this.modifiedDate = modifiedDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getIdentityPlace() {
		return identityPlace;
	}

	public void setIdentityPlace(String identityPlace) {
		this.identityPlace = identityPlace;
	}

	public Date getIdentityDate() {
		return identityDate;
	}

	public void setIdentityDate(Date identityDate) {
		this.identityDate = identityDate;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public long getPositonId() {
		return positonId;
	}

	public void setPositonId(long positonId) {
		this.positonId = positonId;
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
