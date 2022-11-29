package com.csb.t.controllers;

import com.csb.t.dtos.SaveGameDTO;
import com.csb.t.services.GamesService;
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
@RequestMapping("games")
public class GamesController {
    @Autowired
    private GamesService gamesService;

    @GetMapping()
    public String redirectToHome(Model model){
        model.addAttribute("newGame", new SaveGameDTO());

        return "games/home";
    }

    @GetMapping("/history")
    public String redirectToGameHistory(){
        return "games/history";
    }

    @GetMapping("/leaderboards")
    public String redirectToLeaderboards(){
        return "games/leaderboard";
    }

    @PostMapping()
    public String saveGame(@Validated @ModelAttribute("newGame") SaveGameDTO game,
                           BindingResult bindingResult,
                           Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("newGame", game);

            return "redirect:/games";
        }

        gamesService.addOne(game);

        return "redirect:/games/history";
    }
}
