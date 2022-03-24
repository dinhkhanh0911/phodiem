package com.nhom2.phodiem.api;

import java.util.ArrayList;
import java.util.Optional;

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
import com.nhom2.phodiem.entity.MarkConfig;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.Subject;
import com.nhom2.phodiem.entity.User;

@RestController
@RequestMapping(path = "/api/v1/markconfigs")
public class MarkConfigApi {
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	@Autowired
	MarkConfigRepository repository;
	
	
	@GetMapping("")
	ResponseEntity<ResponseObject> findBySubjectName(){
		
		try {
			ArrayList<MarkConfig> foundMarkConfigs = (ArrayList<MarkConfig>) repository.findAll();
			
			if(foundMarkConfigs.size() > 0 ) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject(200,"Tim kiem thanh cong",foundMarkConfigs)
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
	
	/*
	 * @GetMapping("/{subjectId}") ResponseEntity<ResponseObject>
	 * findBySubjectName(@PathVariable long subjectId){
	 * 
	 * try { ArrayList<MarkConfig> foundMarkConfigs = (ArrayList<MarkConfig>)
	 * repository.findBySubjectId(subjectId);
	 * 
	 * if(foundMarkConfigs.size() > 0 ) { return
	 * ResponseEntity.status(HttpStatus.OK).body( new
	 * ResponseObject(200,"Tim kiem thanh cong",foundMarkConfigs) ); } else { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).body( new
	 * ResponseObject(404,"Tim kiem that bai","") ); } } catch (Exception e) { //
	 * TODO: handle exception LOGGER.error(e.getMessage()); return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).body( new
	 * ResponseObject(404,"e.getMessage()","") ); } }
	 */
}
