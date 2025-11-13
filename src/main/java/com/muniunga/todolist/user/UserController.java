package com.muniunga.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel) {
       var user = this.userRepository.findByUsername(userModel.getUsername());
         if (user != null) {
            System.out.println("Username already exists");
            //  throw new RuntimeException("Username already exists");
            return null;
         }
        var savedUser = this.userRepository.save(userModel);
        return savedUser;
    }

}
