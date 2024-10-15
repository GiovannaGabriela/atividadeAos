package com.aosprojeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.aosprojeto.exception.UserNotFoundException;
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

    @GetMapping("nome/{nome}")
    public User getUserByName (@PathVariable ("nome") String nome){
            return  userService.findByNome(nome);
        
    }

    @GetMapping("all")
    public List<User> getAll(){
        return userService.findAll();
    }

    @PostMapping(value = "add")
    public void insiraUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @PutMapping("update/{id}/{nome}")
    public void updateUserNome(@PathVariable ("id") Long id, @PathVariable String nome){
        try {
            userService.updateUserNome(id, nome);
        } catch (UserNotFoundException e) {

        }
    }
   
    @DeleteMapping("nome/{nome}")
    public void deleteUserByNome(@PathVariable String nome){
        try {
            userService.deleteByNome(nome);
        } catch (UserNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


}
