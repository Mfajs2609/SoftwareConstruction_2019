package edu.kea.math.goatsite.controller.api;

import edu.kea.math.goatsite.Repository.DislikeRepository;
import edu.kea.math.goatsite.model.Dislike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class DislikeApiController {

    @Autowired
    private DislikeRepository dislikeRepository;

    @PostMapping("/goatDisliker")
    public Dislike dislikeGoat(@RequestBody Dislike dislike){
        return dislikeRepository.save(dislike);
    }



}
