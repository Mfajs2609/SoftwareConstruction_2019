package edu.kea.math.springintro.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){

        return "Welcome to the greetings API version 1.0.0";
    }


    //http://localhost:8080/greetings?name=Mathias
    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public String greetings(@RequestParam(value = "name", required = false) String name){
        if(name == null){
            return "Hello, Who are you?";
        }
        return "Hello " + name;
    }

    //
    @RequestMapping(value = "/greetings/{personId}", method = RequestMethod.GET)
    public String mingleWithPerson(@PathVariable(value = "personId") Integer personId){
        System.out.println(personId);

        switch(personId) {
            case 0:
                return "Hellesøe";
            case 1:
                return "Simone";
            case 2:
                return "Nikolaj";
            default:
                return "Mathias";
        }


    }

    @RequestMapping(value ="/body" , method = RequestMethod.POST)
        public String showMeTheBody(@RequestBody String body){
        //body = "Test";
        return body;
    }


    //RequestMethod GET
    //kan benyttes med String query og pathvariabler.
    //Kan ikke sende en body.

    //RequestMethod POST
    //Kan sende en body
    //Mere sikkerhed idet body er krypteret

    //REST insomnia


}
