package com.nhom2.phodiem.services;

import java.util.Optional;

import javax.websocket.RemoteEndpoint.Async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nhom2.phodiem.entity.PhoDiemException;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.UserRepository;

public class UserServices {
	
	
	@Autowired
	UserRepository repository;
	
	public Optional<User> get(long userId){
		return repository.findById(userId);
	}
	
	public int deleteService(long userId) throws PhoDiemException {
		Optional<User> foundUsers = repository.findById(userId);
		
		if(foundUsers.isPresent()) {
			repository.deleteById(userId);
			return 1;
		}
		else {
			throw new PhoDiemException("Xóa thất bại");
		}
	}
}
