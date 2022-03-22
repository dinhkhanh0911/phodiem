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
@RequestMapping(path = "/api/v1/khoa")
public class KhoaApi {
//	@Autowired
//	SemesterRespository repositories;

	@GetMapping(value = "")
	ResponseEntity<ResponseObject> insertPerson() {

//		List<Semester> semester = repositories.findAll();
		
		if (true) {

			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, "Tim kiem thanh cong", ""));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(404, "Tim kiem that bai", ""));
		}
	}
}
