package com.nhom2.phodiem.api;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.controller.UserController;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.Subject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.subjectRepository;

@RestController
@RequestMapping(path = "/api/v1/subjects")
public class subjectApi {
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	@Autowired
	subjectRepository repository;
	
	@GetMapping("")
	ResponseEntity<ResponseObject> findAll(){
		
		try {
			ArrayList<Subject> foundSubjects = (ArrayList<Subject>) repository.findAll();
			
			if(foundSubjects.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(200,"Tim kiem thanh cong",foundSubjects)
					);
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new ResponseObject(404,"Tim kiem that bai","")
					);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject(404,"e.getMessage()","")
			);
		}
	}
}
