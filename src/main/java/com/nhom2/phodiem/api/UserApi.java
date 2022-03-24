package com.nhom2.phodiem.api;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.entity.Person;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.UserRepository;

import antlr.collections.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserApi {
	
	@Autowired
	UserRepository repository;
	
	@PostMapping("/info")
	public ResponseEntity<ResponseObject> changeInfo(@Valid @RequestBody User user,BindingResult bindingResult){
		
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Đăng nhập thành công",bindingResult.getAllErrors())
			);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Đăng nhập thành công",repository.save(user))
			);
		}
	}
	@GetMapping("/{userId}")
	ResponseEntity<ResponseObject> findById(@PathVariable long userId){
		Optional<User> foundPerson = repository.findById(userId);
		
		if(foundPerson.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Tim kiem thanh cong",foundPerson)
				);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject(404,"Tim kiem that bai","")
				);
		}
	}
	@GetMapping("/search/{q}")
	ResponseEntity<ResponseObject> findUser(@PathVariable String q){
		ArrayList<User> foundUsers = (ArrayList<User>) repository.searchByNameLike(q);
		
		if(foundUsers.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Tim kiem thanh cong",foundUsers)
				);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject(404,"Tim kiem that bai","")
				);
		}
	}
	@PostMapping("/info/{userId}")
	ResponseEntity<ResponseObject> updateInfo(@Valid @RequestBody User user,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Đăng nhập thành công",bindingResult.getAllErrors())
			);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Đăng nhập thành công",user)
			);
		}
	}
}
