package com.nhom2.phodiem.api;

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

import com.nhom2.phodiem.entity.Person;
import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.respository.PersonRepository;

@RestController
@RequestMapping(path = "/api/v1/report")
public class XuatDuLieu1Controller {
	
	@PostMapping(value = "/insert")
	ResponseEntity<ResponseObject> insertPerson(@RequestParam(name = "name") String rq){
		return ResponseEntity.status(HttpStatus.OK).body(
			new ResponseObject(200,"Them thanh cong",rq)
		);		
	}
}
