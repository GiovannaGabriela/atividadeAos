package com.aosprojeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aosprojeto.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  
    public User findByNome(String nome);
    public void deleteByNome(String nome);

}