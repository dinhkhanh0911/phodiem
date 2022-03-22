package com.nhom2.phodiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhom2.phodiem.respository.PersonRepository;

@Controller
public class TheoDoiDiem {
//	@Autowired
//	PersonRepository personRepository;
	
	@RequestMapping(value = "/theo-doi-diem")
	public String index() {
		return "theodoidiem/theodoidiem";
	}
}
