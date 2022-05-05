package com.nhom2.phodiem;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.nhom2.phodiem.api.UserApi;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;

@SpringBootTest
@Transactional
public class TestUserApi {
	@Autowired
	UserApi userApi;
	
	@Autowired
    private Validator validator;
	
	@Test
	public void testAddSuccess() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2212","09112000","Đinh Văn Khánh","0987654321","Dinhvankhanh102@gmail.com",
				"Đan Phượng",1,
				date,"123456789","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		ResponseObject responseObject = result.getBody();
		System.out.println(responseObject.getMessage());
		assertEquals(result.getStatusCodeValue(), 200);
	}
	
	//Bỏ trống tên
	@Test
	public void testAddFailedFullName() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2211","09112000","","0987654321","Dinhvankhanh102@gmail.com",
				"Đan Phượng",1,
				date,"123456789","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	//Bỏ trống tài khoản
	@Test
	public void testAddFailedUserName() {
		
		Date date = Date.valueOf("2000-11-09");
		User user = new User("","09112000","Đinh Văn Khánh","0987654321","Dinhvankhanh102@gmail.com",
				"Đan Phượng",1,
				date,"123456789","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	//Bỏ trống mật khẩu
	@Test
	public void testAddFailedPassword() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2211","","Đinh Văn Khánh","0987654321","Dinhvankhanh102@gmail.com",
				"Đan Phượng",1,
				date,"123456789","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	//Bỏ trống email
	@Test
	public void testAddFailedEmail() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2211","09112000","Đinh Văn Khánh","0987654321","",
				"Đan Phượng",1,
				date,"123456789","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	//Bỏ trống số CCCD
	@Test
	public void testAddFailedIdentifyNumber() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2211","09112000","Đinh Văn Khánh","0987654321","Dinhvankhanh102@gmail.com",
				"Đan Phượng",1,
				date,"","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	//Sai định dạng email
	@Test
	public void testAddFailedWrongEmail() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2211","09112000","Đinh Văn Khánh","0987654321","Dinhvankhanh102@gmail",
				"Đan Phượng",1,
				date,"123456789","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	//Sai định dạng số điện thoại
	@Test
	public void testAddFailedWrongPhoneNumber() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2212","09112000","Đinh Văn Khánh","0987654321abc","Dinhvankhanh102@gmail.com",
				"Đan Phượng",1,
				date,"123456789","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	@Test
	public void testAddFailedWrongIndentifyNumber() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2212","09112000","Đinh Văn Khánh","0987654321","Dinhvankhanh102@gmail.com",
				"Đan Phượng",1,
				date,"123456789abc","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		ResponseObject responseObject = result.getBody();
		System.out.println(responseObject.getMessage());
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	//Trùng tài khoản
	@Test
	public void testAddFailedDuplicateUserName() {
		Date date = Date.valueOf("2000-11-09");
		User user = new User("tktk2211","09112000","Đinh Văn Khánh","0987654321","Dinhvankhanh102@gmail.com",
				"Đan Phượng",1,
				date,"123456789","Đan Phượng",date,null);
		BindingResult mockBindingResult = new BeanPropertyBindingResult(user,"objectName");
		validator.validate(user, mockBindingResult);
		ResponseEntity<ResponseObject>  result = userApi.addinfo(user, mockBindingResult);
		ResponseObject responseObject = result.getBody();
		System.out.println(responseObject.getMessage());
		assertEquals(result.getStatusCodeValue(), 400);
	}
	
	//Tìm kiếm thành công
	@Test
	public void testFindSuccess() {
		
		
		long a = 7;
		ResponseEntity<ResponseObject>  result = userApi.findById(a);
//			ResponseObject responseObject = result.getBody();
//			System.out.println(responseObject.getMessage());
		assertEquals(result.getStatusCodeValue(), 200);
		
	}
		
	//Tìm kiếm thất bại
	@Test
	@Transactional
	public void testFindFailed() {
		
		
		long a = 100;
		ResponseEntity<ResponseObject>  result = userApi.findById(a);
		assertEquals(result.getStatusCodeValue(), 400);
		
	}
	
	//Tìm kiếm người dùng thành công
	@Test
	public void testFindUserSuccess() {
		
		
		String a = "khanh";
		ResponseEntity<ResponseObject>  result = userApi.findUser(a);
		assertEquals(result.getStatusCodeValue(), 200);
		
	}
	
	//Tim kiem nguoi dùng thất bại
	@Test
	public void testFindUserFailed() {
		
		
		String a = "ssss";
		ResponseEntity<ResponseObject>  result = userApi.findUser(a);
		assertEquals(result.getStatusCodeValue(), 400);
		
	}
		
	//Xóa thành công
	@Test
	public void testDeleleSuccess() {
		
		
		long a = 7;
		ResponseEntity<ResponseObject>  result = userApi.deleteUser(a);
//		ResponseObject responseObject = result.getBody();
//		System.out.println(responseObject.getMessage());
		assertEquals(result.getStatusCodeValue(), 200);
		
	}
	
	//Xóa thất bại
	@Test
	@Transactional
	public void testDeleleFailed() {
		
		
		long a = 100;
		ResponseEntity<ResponseObject>  result = userApi.deleteUser(a);
		assertEquals(result.getStatusCodeValue(), 400);
		
	}
	
	//Test sửa thông tin người dùng tương tự chức năng thêm
}
