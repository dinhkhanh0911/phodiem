package com.nhom2.phodiem.api;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.nhom2.phodiem.controller.UserController;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.UserRepository;

import net.bytebuddy.utility.privilege.GetMethodAction;

@RestController
@RequestMapping(path = "/api/v1/login")
public class LoginApi {
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	@Autowired
	UserRepository repository;
	
	@PostMapping("")
	public ResponseEntity<ResponseObject> dangNhap(@RequestBody User user,HttpSession session) {
		try {
			Optional<User> optionalUser = repository.findByUserName(user.getUserName());
			if(optionalUser.isPresent()) {
				if(optionalUser.get().getPassWord().equals(user.getPassWord())) {
					session.setAttribute("user", optionalUser.get().getUserName());
					session.setAttribute("userId", optionalUser.get().getUserId());
					
					return ResponseEntity.status(HttpStatus.OK).body(
							new ResponseObject(200,"Đăng nhập thành công",user.getUserName())
					);
				}
				else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
							new ResponseObject(400,"Thông tin tài khoản không chính xác","")
					);
				}
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						new ResponseObject(400,"Đăng nhập thất bại","")
				);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseObject(500,e.getMessage(),"")
			);
		}
		
	}
}
