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

	String manageRepair(org.springframework.ui.Model model,HttpSession session);

	String editRepair(long rid, org.springframework.ui.Model model);

	String editRepair(RedirectAttributes attributes, AddRepairDto addRepair, HttpSession session);

	String delteRepair(long rid, RedirectAttributes attributes);

	String pendingRepairs(HttpSession session, org.springframework.ui.Model model);

	String completedRepairs(HttpSession session, ModelMap map);

}
