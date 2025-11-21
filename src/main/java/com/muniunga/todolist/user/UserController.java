package com.muniunga.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
       var user = this.userRepository.findByUsername(userModel.getUsername());
         if (user != null) {
            System.out.println("Username already exists");        
            // Mensagem de erro
            // status code 409
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).body("Username already exists");
         }
        var savedUser = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(savedUser);
    }

}
