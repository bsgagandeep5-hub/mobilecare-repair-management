package com.example.MobileCare.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MobileCare.Dto.AddRepairDto;
import com.example.MobileCare.Dto.UserDto;
import com.example.MobileCare.Service.MyService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
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
	
	@PostMapping("/login")
	public String login(@RequestParam("username")String username, @RequestParam("password")String password,HttpSession session,
			RedirectAttributes attributes, org.springframework.ui.Model model) {
		return service.loginCheck(username,password,session,attributes, model);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, ModelMap map) {
	    return service.dashboard(session,map);
	}
	
	@GetMapping("/add-repair")
	public String addRepair() {
		return "addRepair.html";
	}
	
	@PostMapping("/add-repair")
	public String addRepair(RedirectAttributes attributes,@ModelAttribute AddRepairDto addRepair, HttpSession session) {
		return service.addRepair(attributes,addRepair, session);
	}
	
	@GetMapping("/manage-repairs")
	public String manageRepair(org.springframework.ui.Model model, HttpSession session) {
		return service.manageRepair(model, session);
	}
	
	@GetMapping("/edit-repair")
	public String editRepair(@RequestParam("rid") long rid, org.springframework.ui.Model model) {
		return service.editRepair(rid, model);
	}
	
	@PostMapping("/edit-repair")
	public String editRepair(RedirectAttributes attributes, @ModelAttribute AddRepairDto addRepair, HttpSession session) {
		return service.editRepair(attributes, addRepair, session);
	}
	
	@GetMapping("/delete-repair/{rid}")
	public String deleteRepair(@PathVariable("rid")long rid, RedirectAttributes attributes) {
		return service.delteRepair(rid, attributes);
	}
	
	@GetMapping("/pending-repairs")
	public String pendingRepairs(HttpSession session,org.springframework.ui.Model model) {
		return service.pendingRepairs(session, model);
	}
	
	@GetMapping("/completed-repairs")
	public String completedRepairs(HttpSession session, ModelMap map) {
		return service.completedRepairs(session,map);
	}
}
