package com.muniunga.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/users")
public class UserController {
   
    @PostMapping
    public void createUser(@RequestBody UserModel userModel) {
        System.out.println("Username: " + userModel.getUsername());
        System.out.println("Name: " + userModel.getName());
        System.out.println("Password: " + userModel.getPassword());
    }    

}
