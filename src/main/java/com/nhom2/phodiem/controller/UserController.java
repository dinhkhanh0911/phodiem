package com.nhom2.phodiem.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nhom2.phodiem.entity.Person;
import com.nhom2.phodiem.entity.User;
import com.nhom2.phodiem.respository.PersonRepository;
import com.nhom2.phodiem.respository.UserRepository;

@Controller
@RequestMapping(value = "/nguoi-dung")
@SessionAttributes({"user"})
public class UserController {
	
	
	 private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	@Autowired
	UserRepository repository;
	
	public boolean checkSession(HttpSession session) {
		if(session.getAttribute("user") == null) return true;
		else return false;
	}
	
	@GetMapping(value = "/menu-quan-ly")
	public String menuUser(HttpSession session) {
		try {
			if(!checkSession(session)) return "/nguoidung/menunguoidung";
			return "redirect:/dang-nhap";
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return "redirect:/dang-nhap";
		}
	}
	@GetMapping(value = "/them-nguoi-dung")
	public String create(HttpSession session) {
		
		try {
			if(!checkSession(session)) {
				
				return "/nguoidung/themnguoidung";
			}
			return "redirect:/dang-nhap";
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return "redirect:/dang-nhap";
		}
	}
	
	@GetMapping(value = "/thay-doi-thong-tin-nguoi-dung/{userId}")
	public String changeInfo(HttpSession session,@PathVariable long userId,Model model) {
		
		try {
			if(!checkSession(session)) {
				
				User user = repository.findById(userId).get();
				System.out.println(user);
				model.addAttribute("userModel", user);
				return "/nguoidung/capnhatnguoidung";
			}
			
			return "redirect:/dang-nhap";
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return "redirect:/dang-nhap";
		}
	}
	@GetMapping(value = "/tim-kiem")
	public String changeInfo(HttpSession session) {
		
		try {
			if(!checkSession(session)) {
				return "/nguoidung/timkiemnguoidung";
			}
			
			return "redirect:/dang-nhap";
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return "redirect:/dang-nhap";
		}
	}
	
	@GetMapping(value = "/ca-nhan")
	public String info(HttpSession session) {
		
		try {
			if(!checkSession(session)) return "/nguoidung/menucanhan";
			return "redirect:/dang-nhap";
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return "redirect:/dang-nhap";
		}
	}
	
	@GetMapping(value = "/thay-doi-thong-tin-ca-nhan")
	public String changeInfo(HttpSession session,Model model) {
		try {
			if(!checkSession(session)) {
				
//				String userName = (String) session.getAttribute("user");
				Long userId = (Long)session.getAttribute("userId");
				
				User user = repository.findById(userId).get();
				model.addAttribute("userModel", user);
				return "/nguoidung/thongtincanhan";
			}
			
			return "redirect:/dang-nhap";
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return "redirect:/dang-nhap";
		}
	}
}
