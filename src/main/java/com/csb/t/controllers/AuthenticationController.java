package com.csb.t.controllers;

import com.csb.t.dtos.SignInDTO;
import com.csb.t.dtos.SignUpDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class AuthenticationController {
    @GetMapping("/")
    public String defaultRedirect(Model model){
        model.addAttribute("existingUser", new SignInDTO());

        return "redirect:/signIn";
    }

    @GetMapping("/signIn")
    public String signIn(Model model){
        model.addAttribute("existingUser", new SignInDTO());

        return "authentication/signIn";
    }

    @GetMapping("/signUp")
    public String signUp(Model model){
        model.addAttribute("newUser", new SignUpDTO());

        return "authentication/signUp";
    }
}
