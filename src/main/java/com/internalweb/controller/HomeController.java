package com.internalweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.internalweb.model.User;
import com.internalweb.repository.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;

    @GetMapping(value= {"/","/login"})
    public String homePage() {
        return "home"; 
    }
    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                String role = user.getRole();
                if ("manager".equals(role)) {
                    return "redirect:/manager";
                } else if ("staff".equals(role)) {
                    return "redirect:/staff";
                }
            }
        }
        redirectAttributes.addAttribute("error", true);
        return "redirect:/login";
    }
    
    @GetMapping("/manager")
    public String ManagerPage() {
        return "manager"; 
    }
    
    @GetMapping("/staff")
    public String StaffPage() {
    	return "staff";
    }
    
    @GetMapping("/introduction")
    public String IntroductionPage() {
    	return "introduction";
    }
}

