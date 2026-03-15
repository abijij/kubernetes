package org.abijij.spring.msvc.users.msvc_users.controllers;


import org.abijij.spring.msvc.users.msvc_users.models.entity.User;
import org.abijij.spring.msvc.users.msvc_users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/list")
    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        Optional<User> userOptional = service.findById(id);
        if (userOptional.isPresent()){
            return ResponseEntity.ok().body( userOptional.get());
        }
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@RequestBody User user){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody User user, @PathVariable Long id){
           Optional<User> userOptional = service.findById(id);
           if (userOptional.isPresent()){
               User userDb = userOptional.get();
               userDb.setName(user.getName());
               userDb.setEmail(user.getEmail());
               userDb.setPassword(user.getPassword());

               return ResponseEntity.status(HttpStatus.CREATED).body(service.save(userDb));
           }

        return ResponseEntity.notFound().build();
    }
}
