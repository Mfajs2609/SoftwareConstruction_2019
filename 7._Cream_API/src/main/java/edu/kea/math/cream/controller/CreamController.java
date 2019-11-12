package edu.kea.math.cream.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kea.math.cream.model.Cream;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class CreamController {

    ArrayList<Cream> cream = new ArrayList<Cream>();

    @RequestMapping(value = "/cream", method = RequestMethod.GET)
    public String home() {

        return "Welcome";
    }

    @RequestMapping(value = "/cream/{id}", method = RequestMethod.GET)
    public Cream creamWithId(@PathVariable(value = "id") Integer id){

        ArrayList<Cream> creams = new ArrayList<Cream>();
        creams.add(new Cream(0, true));
        creams.add(new Cream(1, false));
        creams.add(new Cream(2, true));
        creams.add(new Cream(3, false));

        return creams.get(id);
    }

    @RequestMapping(value = "/cream/{id}", method = RequestMethod.DELETE)
    public String deleteCream(@PathVariable Integer id){
        if(id >= 0 && id < cream.size()) {
            cream.remove(id);
            return "Deleted True";
        }
        return "Deleted False";

    }

    @RequestMapping(value = "/cream/{id}", method = RequestMethod.POST)
    public String postCream(@RequestBody String body){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Cream newCream = objectMapper.readValue(body, Cream.class);
            cream.add(newCream);
            return"Successfully created cream, status: 200";

        } catch (IOException e) {
            e.printStackTrace();
            return "Could not parse the body. Did you specify the correct values";
        }
    }

/*
    @RequestMapping(value = "/cream", method = RequestMethod.GET)
    public String getCream{


        String response ="";
        String newLine = "";
             for (Cream c : cream){
                 response += c +newLine;
             }
        return response;
    }
*/
    /*@RequestMapping(value = "/cream/{id}", method = RequestMethod.DELETE)
    public String deleteCream(@PathVariable Integer id){
    if(id >= 0 && id < cream.size()) {
        cream.remove(id);
        return "Deleted True";
    }
    return "Deleted False";
}
*/
}

