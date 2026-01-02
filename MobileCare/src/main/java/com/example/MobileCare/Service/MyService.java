package com.example.MobileCare.Service;

import org.springframework.validation.BindingResult;

import com.example.MobileCare.Dto.UserDto;

import jakarta.validation.Valid;

public interface MyService {

	String signUpValidation(@Valid UserDto userDto, BindingResult result);

}
