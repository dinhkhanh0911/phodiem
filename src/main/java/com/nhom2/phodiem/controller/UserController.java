package com.nhom2.phodiem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	
	
	@Autowired
	UserRepository repository;
	
	public boolean checkSession(HttpSession session) {
		if(session.getAttribute("user") == null) return true;
		else return false;
	}
	
	@GetMapping(value = "/menu-quan-ly")
	public String menuUser(HttpSession session) {
		if(!checkSession(session)) return "/nguoidung/menunguoidung";
		return "redirect:/dang-nhap";
	}
	@GetMapping(value = "/them-nguoi-dung")
	public String create(HttpSession session) {
		if(!checkSession(session)) {
			
			return "/nguoidung/themnguoidung";
		}
		return "redirect:/dang-nhap";
	}
	
//	@PostMapping(value = "/them-nguoi-dung")
//	public String create(@ModelAttribute Person user) {
//		personRepository.save(user);
//		return "redirect:/nguoi-dung/cap-nhat-nguoi-dung";
//		
//	}
	
	@GetMapping(value = "/thay-doi-thong-tin-nguoi-dung/{userId}")
	public String changeInfo(HttpSession session,@PathVariable long userId,Model model) {
		if(!checkSession(session)) {
			
			User user = repository.findById(userId).get();
			System.out.println(user);
			model.addAttribute("userModel", user);
			return "/nguoidung/thongtincanhan";
		}
		
		return "redirect:/dang-nhap";
	}
	@GetMapping(value = "/tim-kiem")
	public String changeInfo(HttpSession session) {
		if(!checkSession(session)) {
			return "/nguoidung/timkiemnguoidung";
		}
		
		return "redirect:/dang-nhap";
	}
	
	@GetMapping(value = "/ca-nhan")
	public String info(HttpSession session) {
		if(!checkSession(session)) return "/nguoidung/menucanhan";
		return "redirect:/dang-nhap";
	}
	
	@GetMapping(value = "/thay-doi-thong-tin-ca-nhan")
	public String changeInfo(HttpSession session,Model model) {
		if(!checkSession(session)) {
			
//			String userName = (String) session.getAttribute("user");
			Long userId = (Long)session.getAttribute("userId");
			
			User user = repository.findById(userId).get();
			System.out.println(user);
			model.addAttribute("userModel", user);
			return "/nguoidung/thongtincanhan";
		}
		
		return "redirect:/dang-nhap";
	}
}
