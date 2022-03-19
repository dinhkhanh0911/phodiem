package com.nhom2.phodiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhom2.phodiem.entity.Person;
import com.nhom2.phodiem.respository.PersonRepository;

@Controller
@RequestMapping(value = "/nguoi-dung")
public class UserController {
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping(value = "/them-nguoi-dung")
	public String create() {
		return "/nguoidung/themnguoidung";
	}
	
	@PostMapping(value = "/them-nguoi-dung")
	public String create(@ModelAttribute Person user) {
		personRepository.save(user);
		return "redirect:/nguoi-dung/cap-nhat-nguoi-dung";
		
	}
	
	@GetMapping(value = "cap-nhat-nguoi-dung")
	public String update() {
		return "/nguoidung/capnhatnguoidung";
	}
}
