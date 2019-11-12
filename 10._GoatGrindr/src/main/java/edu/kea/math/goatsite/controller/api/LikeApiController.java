package edu.kea.math.goatsite.controller.api;

import edu.kea.math.goatsite.Repository.LikeRepository;
import edu.kea.math.goatsite.model.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
public class LikeApiController {

    @Autowired
    private LikeRepository likeRepository;


    @PostMapping("/goatliker")
    public Like likeGoat(@RequestBody Like like){
        return likeRepository.save(like);

    }
}
