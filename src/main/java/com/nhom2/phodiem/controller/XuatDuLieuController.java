package com.nhom2.phodiem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class XuatDuLieuController {
	@GetMapping("/report")
	public String index() {
		return "xuatdulieu/index";
	}
}
