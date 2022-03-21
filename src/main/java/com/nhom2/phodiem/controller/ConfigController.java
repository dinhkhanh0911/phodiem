package com.nhom2.phodiem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigController {
	@GetMapping("/config")
	public String index() {
		return "config/config";
	}
}
