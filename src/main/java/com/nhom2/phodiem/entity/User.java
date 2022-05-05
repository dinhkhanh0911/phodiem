package com.nhom2.phodiem.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Data
@Getter 
@Setter
public class User {
	
	public User() {
		
	}
	public User(String userName, String passWord,String fullName,
			String phoneNumber,
			String email, String address, int gender, Date dateOfBrith,
			String identityNumber, String identityPlace,
			Date identityDate,Position position) {
		super();
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
		this.position = position;
	}
	public User(String userName, String passWord,
			String phoneNumber,
			String email, String address, int gender, Date dateOfBrith,
			String identityNumber, String identityPlace,
			Date identityDate,Position position) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.dateOfBrith = dateOfBrith;
		this.identityNumber = identityNumber;
		this.identityPlace = identityPlace;
		this.identityDate = identityDate;
		this.position = position;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(nullable = false)
	@NotBlank(message = "* Trường không để trống")
	private String userName;
	
	@Column(nullable = false)
	@NotBlank(message = "* Trường không để trống")
	private String passWord;
	
	@Column(nullable = false)
	@NotBlank(message = "* Trường không để trống")
	private String fullName;
	
	@Pattern(regexp="^[0-9]*$",message = "Số điện thoại chưa hợp lệ")
	private String phoneNumber;
	
	@Column(nullable = false)
	@NotBlank(message = "* Trường không để trống")
	@Email(message = "Email chưa hợp lệ")
	private String email;
	

	private String address;
	private int gender;
	private Date dateOfBrith;
	
	@Column(nullable = false)
	@NotBlank(message = "* Trường không để trống")
	@Pattern(regexp="^[0-9]*$",message = "Số CCCD chưa hợp lệ")
	private String identityNumber;
	
	private String identityPlace;
	private Date identityDate;
	private String positionName;
	
	
	@ManyToOne
	@JoinColumn(name = "positionId")
	private Position position;
	private String createBy;
	private Date createDate;
	private String modifiedByString;
	private Date modifiedDate;

	@OneToOne(mappedBy = "user")
	private Student student;
	
	@OneToOne(mappedBy = "user")
	private Teacher teacher;

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

//	public Position getPosition() {
//		return position;
//	}
//
//	public void setPosition(Position position) {
//		this.position = position;
//	}

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

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//	public Teacher getTeacher() {
//		return teacher;
//	}
//
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}
	

}
