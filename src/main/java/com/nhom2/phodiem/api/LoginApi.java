package com.nhom2.phodiem.api;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.UserRepository;

@RestController
@RequestMapping(path = "/api/v1/login")
public class LoginApi {
	
	@Autowired
	UserRepository repository;
	
	@PostMapping("")
	public ResponseEntity<ResponseObject> dangNhap(@RequestBody User user,HttpSession session) {
		Optional<User> optionalUser = repository.findByUserName(user.getUserName());
		if(optionalUser.isPresent() && optionalUser.get().getPassWord().equals(user.getPassWord())) {
//			System.out.println();
			session.setAttribute("user", optionalUser.get().getUserName());
			session.setAttribute("userId", optionalUser.get().getUserId());
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Đăng nhập thành công",user.getUserName())
			);
			
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject(404,"Đăng nhập thất bại","")
			);
		}
		
	}
}
