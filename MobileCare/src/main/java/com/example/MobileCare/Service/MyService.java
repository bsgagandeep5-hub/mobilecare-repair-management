package com.example.MobileCare.Service;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MobileCare.Dto.AddRepairDto;
import com.example.MobileCare.Dto.UserDto;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

public interface MyService {

	String signUpValidation(@Valid UserDto userDto, BindingResult result);

	String loginCheck(String username, String password, HttpSession session, RedirectAttributes attributes, org.springframework.ui.Model model);

	String dashboard(HttpSession session, ModelMap map);

	String addRepair(RedirectAttributes attributes, AddRepairDto addRepair, HttpSession session);

}
