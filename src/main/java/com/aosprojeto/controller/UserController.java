package com.aosprojeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aosprojeto.model.User;
import com.aosprojeto.service.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("nome/{nome}/")
    public User getUserByName (@PathVariable ("nome") String nome){
            return  userService.findByNome(nome);
        
    }

    @PostMapping(value = "add/")
    public void insiraUser(@RequestBody User user){
        userService.insertUser(user);
    }

   


}
