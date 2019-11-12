package edu.kea.math.goatsite.controller.api;

import edu.kea.math.goatsite.Repository.GoatRepository;
import edu.kea.math.goatsite.model.Gender;
import edu.kea.math.goatsite.model.Goat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class GoatApiController {

    @Autowired
    private GoatRepository goatRepository;

    @GetMapping("/goats")
    public Iterable<Goat> getGoats(){
        return goatRepository.findAll();
    }

    //Find by id
    @GetMapping("/goats/{id}")
    public Object getGoatById(@PathVariable long id) {
    /*    Optional goatOrNull = goatRepository.findById(id);

        if(goatOrNull.isPresent()){
            return goatOrNull.get();

        }else{
            return "404 - Goat not found";
        }
    }
    */
        return goatRepository.findById(id).orElse(null);
    }

    //Find by name
    @GetMapping("/goats/findbyname")
    public Iterable<Goat> getGoatByName(@RequestParam(value = "name") String name){

        return goatRepository.findAllByName(name);
    }

    //Find by gender
    @GetMapping("/goats/findbygender")
    public Iterable<Goat> getGoatByGender(@RequestParam(value = "gender") Gender gender){

        return goatRepository.findAllByGender(gender);
    }

    //Find oldtimers
    @GetMapping("/goats/oldtimers")
    public Iterable<Goat> getOldTimers(){
        return goatRepository.findTheOldTimers();
    }

    @PostMapping("/creategoats")
    public Goat createGoat(@Valid @RequestBody Goat goat){
        return goatRepository.save(goat);
    }
}


