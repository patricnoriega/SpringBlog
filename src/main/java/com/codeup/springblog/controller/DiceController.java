package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {
    @GetMapping("/roll-dice/{n}")
    public String rollDiceUser(@PathVariable int n, Model model) {
        int random = ThreadLocalRandom.current().nextInt(1,6+1);
        model.addAttribute("randomNumber", random);
        model.addAttribute("userGuess", n);
        model.addAttribute("isUserGuessCorrect", n == random);
        return "dice";
    }

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "dice";
    }
}
