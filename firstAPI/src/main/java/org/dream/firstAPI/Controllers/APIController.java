package org.dream.firstAPI.Controllers;

import org.dream.firstAPI.Models.User;
import org.dream.firstAPI.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
public class APIController {
    int num = 0;


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
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setOccupation(user.getOccupation());
        updateUser.setAge(user.getAge());
        userRepo.save(updateUser);
        return "Updated.....";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete User with the ID: " +id;
    }

    @GetMapping( "/hello/")
    public static String getPage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Why do you want to enter?");
        String str = scanner.nextLine();
        System.out.println(str);
        return str;
    }
    @GetMapping( "/test/")
    public int countByRefreshing(){
        num++;
        return num;
    }

}
