package com.example.MobileCare.Service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.MobileCare.Dto.UserDto;
import com.example.MobileCare.Entity.Admin;
import com.example.MobileCare.Entity.Customer;
import com.example.MobileCare.Repository.AdminRepo;
import com.example.MobileCare.Repository.CustRepo;
import com.example.MobileCare.Repository.RepairRepo;

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

}
