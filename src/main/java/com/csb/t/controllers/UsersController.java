package com.csb.t.controllers;

import com.csb.t.dtos.SignUpDTO;
import com.csb.t.dtos.SignInDTO;
import com.csb.t.entities.Users;
import com.csb.t.services.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/signUp")
    public String signUp(
            @Validated @ModelAttribute("newUser") SignUpDTO user,
            BindingResult bindingResult,
            Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("newUser", user);

            return "authentication/signUp";
        }

        usersService.addOne(user);

        return "users/home";
    }

    @PostMapping("/signIn")
    public String signIn(
            @Validated @ModelAttribute("existingUser") SignInDTO user,
            BindingResult bindingResult,
            Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("existingUser", user);

            return "authentication/signIn";
        }

        Users existingUser = usersService.validateUser(user);

        if(existingUser == null){
            return "authentication/signIn";
        }

        // Redirect to ADMINISTRATOR DASHBOARD if Role is ADMINISTRATOR
        if(existingUser.getRoleId() == 2){
            return "admin/home";
        }

        return "users/home";
    }
}
