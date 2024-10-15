package com.aosprojeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aosprojeto.exception.UserNotFoundException;
import com.aosprojeto.model.User;
import com.aosprojeto.repository.UserRepository;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    

    /*POST*/

    public void insertUser(User user){
        userRepository.save(user);
    }

    /*GET*/

    public List<User> findAll(){
        return userRepository.findAll();
    }

    /*PUT*/

    public void updateUserNome(Long id, String nome) throws UserNotFoundException{
            Optional<User> optUser  = userRepository.findById(id);
     
            if (optUser.isEmpty()) {
                throw new UserNotFoundException(id); 
            }
     
            User user = optUser.get();
            user.setNome(nome);
            userRepository.save(user);
    }

    /*DELETE*/
        
    public void deleteByNome(String nome) throws UserNotFoundException {
        userRepository.deleteByNome(nome);
    }
    
    /*GET*/
    public User findByNome(String nome){
        return userRepository.findByNome(nome);
    }

    
}
