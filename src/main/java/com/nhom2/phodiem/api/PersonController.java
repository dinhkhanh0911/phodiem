package com.nhom2.phodiem.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.entity.Person;
import com.nhom2.phodiem.entity.Position;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.PersonRepository;
import com.nhom2.phodiem.respository.PositionRepository;
import com.nhom2.phodiem.respository.UserRepository;

@RestController@RequestMapping(path = "/api/v1/persons")
public class PersonController {
	
	@Autowired
	PersonRepository repositories;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PositionRepository positionRepository;
	
	@GetMapping("")
	ResponseEntity<ResponseObject> getAllPerson(){
		List<Person> foundPersons = repositories.findAll();
		
		if(foundPersons.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Tim kiem thanh cong",foundPersons)
				);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(404,"Tim kiem that bai","")
				);
		}
	}
	
	@GetMapping("/search/{id}")
	ResponseEntity<ResponseObject> findById(@PathVariable int id){
		Optional<Person> foundPerson = repositories.findById(id);
		
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
	
	@GetMapping("/search")
	ResponseEntity<ResponseObject> findByName(@RequestParam(name = "name") String name){
		List<Person> foundPersons = repositories.searchByNameLike(name);
		
		if(foundPersons.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Tim kiem thanh cong",foundPersons)
				);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(404,"Tim kiem that bai","")
				);
		}
	}
	
	
	@PostMapping("/insert")
	ResponseEntity<ResponseObject> insertPerson(@RequestBody User newPerson){
		return ResponseEntity.status(HttpStatus.OK).body(
			new ResponseObject(200,"Them thanh cong",userRepository.save(newPerson))
		);
				
	}
	@PostMapping("/insert1")
	ResponseEntity<ResponseObject> insertPerson(@RequestBody Person newPerson){
		return ResponseEntity.status(HttpStatus.OK).body(
			new ResponseObject(200,"Them thanh cong",repositories.save(newPerson))
		);
				
	}
	
	@PostMapping("/tao-position")
	ResponseEntity<ResponseObject> insertPosition(@RequestBody Position position){
		return ResponseEntity.status(HttpStatus.OK).body(
			new ResponseObject(200,"Them thanh cong",positionRepository.save(position))
		);
				
	}
	
	
	
}
