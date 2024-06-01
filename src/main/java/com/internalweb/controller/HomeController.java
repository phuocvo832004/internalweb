package com.internalweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.internalweb.model.User;
import com.internalweb.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value= {"/","/login"})
    public String homePage() {
        return "home"; 
    }
    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user);
            
            String role = user.getRole();
            if ("Manager".equals(role)) {
                return "redirect:/manager";
            } else if ("Staff".equals(role)) {
                return "redirect:/staff";
            }
        }
        redirectAttributes.addAttribute("error", true);
        return "redirect:/login";
    }

    
    @GetMapping("/manager")
    public String managerPage(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !"Manager".equals(loggedInUser.getRole())) {
            return "redirect:/login";
        }
        model.addAttribute("loggedInUser", loggedInUser);
        return "manager";
    }

    @GetMapping("/staff")
    public String staffPage(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !"Staff".equals(loggedInUser.getRole())) {
            return "redirect:/login"; 
        }
        model.addAttribute("loggedInUser", loggedInUser);
        return "staff";
    }


    
    @GetMapping("/introduction")
    public String IntroductionPage() {
    	return "introduction";
    }
    
    @GetMapping("/logout")
    public String handleLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
    
    @GetMapping("/manager-qlnv")
    public String QlnvPage(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !"Manager".equals(loggedInUser.getRole())) {
            return "redirect:/login";
        }
        model.addAttribute("loggedInUser", loggedInUser);
    	return "manager-qlnv";
    }
    
    @GetMapping("/manager-qltb")
    public String QltbPage(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !"Manager".equals(loggedInUser.getRole())) {
            return "redirect:/login";
        }
        model.addAttribute("loggedInUser", loggedInUser);
    	return "manager-qltb";
    }

}

