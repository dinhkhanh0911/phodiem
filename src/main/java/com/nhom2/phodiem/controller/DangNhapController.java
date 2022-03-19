package com.nhom2.phodiem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DangNhapController {

	
	@GetMapping(value = "/dang-nhap")
	public String login() {
		return "dangnhap/dangnhap";
	}
	
	@PostMapping(value = "/dang-nhap/dang-nhap")
	public String login(Model model) {
		return "Thanh cong";
	}
}
