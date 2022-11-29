package com.csb.t.controllers;

import com.csb.t.dtos.SignUpDTO;
import com.csb.t.dtos.SignInDTO;
import com.csb.t.entities.Users;
import com.csb.t.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/home")
    public String redirectToHome(){
        return "users/home";
    }

    @GetMapping("/history")
    public String redirectToGameHistory(){
        return "users/history";
    }

    @GetMapping("/leaderboards")
    public String redirectToLeaderboards(){
        return "users/leaderboard";
    }

    @PostMapping("/signUp")
    public String signUp(
            @Validated @ModelAttribute("newUser") SignUpDTO user,
            BindingResult bindingResult,
            Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("newUser", user);

            return "redirect:/signUp";
        }

        usersService.addOne(user);

        return "redirect:/users/home";
    }

    @PostMapping("/signIn")
    public String signIn(
            @Validated @ModelAttribute("existingUser") SignInDTO user,
            BindingResult bindingResult,
            Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("existingUser", user);

            return "redirect:/signIn";
        }

        Users existingUser = usersService.findOneByEmail(user.getEmailAddress());

        if(existingUser == null){
            return "redirect:/signIn";
        }

        if(existingUser.getPassword().equals(user.getPassword()) == false){
            return "redirect:/signIn";
        }

        return "redirect:/users/home";
    }
}
