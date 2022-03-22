package com.nhom2.phodiem.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.Semester;
import com.nhom2.phodiem.respository.SemesterRespository;

@RestController
@RequestMapping(path = "/api/v1/theodoi")
public class TheoDoiDiemApi {
	@Autowired
	SemesterRespository repositories;
	
	@GetMapping(value="/giaovien")
	ResponseEntity<ResponseObject> getTeacher(){
		
		List<Semester> semester = repositories.findAll();
		
		if(semester.size() > 0) {
			
			
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Tim kiem thanh cong",semester)
				);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(404,"Tim kiem that bai","")
				);
		}	
	}
	
	@GetMapping(value="/lop")
	ResponseEntity<ResponseObject> getLop(){
		
		List<Semester> semester = repositories.findAll();
		
		if(semester.size() > 0) {
			
			
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Tim kiem thanh cong",semester)
				);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(404,"Tim kiem that bai","")
				);
		}	
	}
	@GetMapping(value="/khoa")
	ResponseEntity<ResponseObject> getKhoa(){
		
		List<Semester> semester = repositories.findAll();
		
		if(semester.size() > 0) {
			
			
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(200,"Tim kiem thanh cong",semester)
				);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject(404,"Tim kiem that bai","")
				);
		}	
	}
	
	
}
