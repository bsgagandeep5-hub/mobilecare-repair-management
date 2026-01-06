package com.example.MobileCare.Service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MobileCare.Dto.UserDto;
import com.example.MobileCare.Entity.Admin;
import com.example.MobileCare.Entity.Customer;
import com.example.MobileCare.Repository.AdminRepo;
import com.example.MobileCare.Repository.CustRepo;
import com.example.MobileCare.Repository.RepairRepo;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyServiceImpl implements MyService{

	private final CustRepo custRepo;
	private final AdminRepo adminRepo;
	private final RepairRepo repairRepo;
	
	@Override
	public String signUpValidation(@Valid UserDto userDto, BindingResult result) {
		if(!userDto.getPassword().equals(userDto.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "error.confirmPassword", "* Password and Confirm Password should be same");
		}
		if(custRepo.existsByEmail(userDto.getEmail()) || adminRepo.existsByEmail(userDto.getEmail())) {
			result.rejectValue("email", "error.email", "* Email already exists");
		}
		if(custRepo.existsByPhone(userDto.getPhone()) || adminRepo.existsByPhone(userDto.getPhone())) {
			result.rejectValue("phone", "error.phone", "Phone number already exists");
		}
		if(result.hasErrors()) {
			return "signup.html";
		}
		if(userDto.getRole().equals("CUSTOMER")) {
			Customer customer = new Customer();
			customer.setEmail(userDto.getEmail());
			customer.setName(userDto.getName());
			customer.setPassword(userDto.getPassword());
			customer.setPhone(userDto.getPhone());
			custRepo.save(customer);
		}else {
			Admin admin = new Admin();
			admin.setEmail(userDto.getEmail());
			admin.setName(userDto.getName());
			admin.setPassword(userDto.getPassword());
			admin.setPhone(userDto.getPhone());
			adminRepo.save(admin);
		}
		return "login.html";
	}

	@Override
	public String loginCheck(String username, String password, HttpSession session,RedirectAttributes attributes) {
		username = username.trim();
		if(username.contains("@")) {
			if(custRepo.existsByEmailAndPassword(username,password)) {
				Customer cust = custRepo.findByEmail(username);
				session.setAttribute("user" ,cust );
				return "dashboard.html";
			}else if(adminRepo.existsByEmailAndPassword(username,password)) {
				Admin admin = adminRepo.findByEmail(username);
				session.setAttribute("user", admin);
				return "dashboard.html";
			}else {
				attributes.addFlashAttribute("message", "* Enter Correct Email and Password");
				return "redirect:/login";
			}
		}else if(username.matches("\\d+")) {
			if(custRepo.existsByPhoneAndPassword(username,password)) {
				Customer cust = custRepo.findByPhone(username);
				session.setAttribute("user", cust);
				return "dashboard.html";
			}else if(adminRepo.existsByPhoneAndPassword(username,password)) {
				Admin admin = adminRepo.findByPhone(username);
				session.setAttribute("user", admin);
				return "dashboard.html";
			}else {
				attributes.addFlashAttribute("message", "* Enter Correct Phone and Password");
				return "redirect:/login";
			}
		}
		attributes.addFlashAttribute("message", "* Invalid Credentials");
		return "redirect:/login";
	}

}
