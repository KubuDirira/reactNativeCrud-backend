package com.kubu.ReactNativeCRUD.service;



import com.kubu.ReactNativeCRUD.domain.User;
import com.kubu.ReactNativeCRUD.repo.UserRepo;
import jakarta.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@Transactional(rollbackOn = Exception.class) // rollsback when there is an exception

public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUser(int id){
        return userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public String deleteUser(int  id){
        userRepo.deleteById(id);
        return "User Deleted";
    }









}
