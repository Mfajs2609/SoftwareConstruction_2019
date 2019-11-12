package edu.kea.math.springintro.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class RockPaperScissors {

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String rock(@RequestParam(value = "rock", required = false) String rock) {

        Random generator = new Random();

        int n = generator.nextInt(3)+1;

        if (n == 0) {
            return "Rock" + rock;
        } else if (n == 1) {
            return "Paper" + rock;
        } else if (n == 2) {
            return "Scissors" + rock;
        }

        return "";
    }
}
