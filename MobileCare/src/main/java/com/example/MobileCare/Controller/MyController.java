package com.example.MobileCare.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MobileCare.Dto.UserDto;
import com.example.MobileCare.Service.MyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyController {
	
	private final MyService service;
	
	@GetMapping("/")
	public String loadMain() {
		return "main.html";
	}
	
	@GetMapping("/login")
	public String loadLogin() {
		return "login.html";
	}
	
	@GetMapping("/signup")
	public String loadSignup(UserDto userDto) {
		return "signup.html";
	}
	
	@PostMapping("/signup")
	public String signUp(@Valid UserDto userDto, BindingResult result) {
		return service.signUpValidation(userDto,result);
	}
}
