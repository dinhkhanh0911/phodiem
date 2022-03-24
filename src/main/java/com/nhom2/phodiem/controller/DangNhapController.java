package com.nhom2.phodiem.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nhom2.phodiem.entity.ResponseObject;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.UserRepository;

@Controller
@RequestMapping(path = "/dang-nhap")
public class DangNhapController {

	@Autowired
	UserRepository repository;
	
	@GetMapping("")
	public String login() {
		return "dangnhap/dangnhap";
	}
	
	@GetMapping("/dang-xuat")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/dang-nhap";
	}
}
