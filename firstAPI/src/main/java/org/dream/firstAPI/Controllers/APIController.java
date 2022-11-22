package org.dream.firstAPI.Controllers;

import org.dream.firstAPI.Models.User;
import org.dream.firstAPI.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "/")
    public static String getPage1(){

        return "Hello from our API";
    }
    @GetMapping(value = "/use")
    public List<User> getUser(){
        return userRepo.findAll();
    }
    @PostMapping(value = "save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }

    @GetMapping( "/hello/")
    public static String getPage(){
        return "Hello from our API.....nerd";
    }

}
