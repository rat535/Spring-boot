package com.project.login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.project.login.Model.User;
import com.project.login.services.UserService;

import org.springframework.ui.Model;

@Controller
public class Mycontroller {
	@Autowired
	private UserService userService;
	
	@GetMapping("/regpage")
	public String openRegPage(Model model) {
		model.addAttribute("user",new User());
		return "Register";
	}
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {
		
		boolean status = userService.registerUser(user);
		
		if(status)
		{
			model.addAttribute("Succesmsg", "User registered successfully");
		}
		else {
			model.addAttribute("errormsg", "User not registered ");
		}
		return "Register";
	}
	
	@GetMapping("/LoginPage")
	public String openLoginPage(Model model)
	{
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String submitLoginform(@ModelAttribute("user") User user,Model model)
	{
		User Validuser =userService.loginUser(user.getEmail(), user.getPassword());
		if(Validuser !=null)
		{
			return "profile";
		}
		else
		{
			model.addAttribute("errormsg", "NO Wromg crenditial");
			return "login";
		}
	}
}
