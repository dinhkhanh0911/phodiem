package com.nhom2.phodiem.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.result.Field;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.nhom2.phodiem.entity.Person;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.Semester;
import com.nhom2.phodiem.respository.PersonRepository;
import com.nhom2.phodiem.respository.SemesterRespository;

@RestController
@RequestMapping(path = "/api/v1/report")
public class XuatDuLieu1Controller {
	@Autowired
	SemesterRespository repositories;
	
	@GetMapping(value="")
	ResponseEntity<ResponseObject> getSemester(){
		
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
