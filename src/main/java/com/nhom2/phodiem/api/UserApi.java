package com.nhom2.phodiem.api;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.controller.UserController;
import com.nhom2.phodiem.entity.Person;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.UserRepository;

import antlr.collections.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserApi {
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	@Autowired
	UserRepository repository;
	
	@PostMapping("/info")
	public ResponseEntity<ResponseObject> addinfo(@Valid @RequestBody User user,BindingResult bindingResult){
		
		
		try {
			if (bindingResult.hasErrors()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						new ResponseObject(400,"Dữ liệu chưa chính xác.Vui lòng kiểm tra lại",bindingResult.getAllErrors())
				);
			}
			else {
				Optional<User> optional = repository.findByUserName(user.getUserName());
//				System.out.println(optional.get().getUserName());
				if(optional.isPresent()) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
							new ResponseObject(400,"Tài khoản đã tồn tại trong hệ thống","")
					);
				}
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(200,"Cập nhật thông tin thành công",repository.save(user))
				);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseObject(500,e.getMessage(),"")
			);
		}
	}
	@PutMapping("/info")
	public ResponseEntity<ResponseObject> changeInfo(@Valid @RequestBody User user,BindingResult bindingResult){
		
		
		try {
			if (bindingResult.hasErrors()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						new ResponseObject(400,"Dữ liệu chưa chính xác.Vui lòng kiểm tra lại",bindingResult.getAllErrors())
				);
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(200,"Cập nhật thông tin thành công",repository.save(user))
				);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseObject(500,e.getMessage(),"")
			);
		}
	}
	@GetMapping("/{userId}")
	public ResponseEntity<ResponseObject> findById(@PathVariable long userId){
		
		try {
			Optional<User> foundPerson = repository.findById(userId);
			
			if(foundPerson.isPresent()) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(200,"Tim kiem thanh cong",foundPerson)
					);
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						new ResponseObject(400,"Tim kiem that bai","")
					);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseObject(500,"e.getMessage()","")
			);
		}
	}
	@GetMapping("/search/{q}")
	public ResponseEntity<ResponseObject> findUser(@PathVariable String q){
		
		try {
			ArrayList<User> foundUsers = (ArrayList<User>) repository.searchByNameLike(q);
			
			if(foundUsers.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(200,"Tim kiem thanh cong",foundUsers)
					);
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						new ResponseObject(400,"Tim kiem that bai","")
					);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseObject(500,"e.getMessage()","")
			);
		}
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<ResponseObject> deleteUser(@PathVariable long userId){
		
		try {
			Optional<User> foundUsers = repository.findById(userId);
			
			if(foundUsers.isPresent()) {
				repository.deleteById(userId);
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(200,"Xóa thành công","")
					);
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						new ResponseObject(400,"Xóa thất bại","")
					);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseObject(500,e.getMessage(),"")
			);
		}
	}
	@PostMapping("/info/{userId}")
	public ResponseEntity<ResponseObject> updateInfo(@Valid @RequestBody User user,BindingResult bindingResult){
		
		try {
			if (bindingResult.hasErrors()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
						new ResponseObject(400,"Cập nhật không thành công",bindingResult.getAllErrors())
				);
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(200,"Cập nhật thành công",user)
				);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new ResponseObject(500,"e.getMessage()","")
			);
		}
	}
}
