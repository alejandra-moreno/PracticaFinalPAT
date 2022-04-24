package com.example.demo.service.implementation;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<UserModel> getUser(){
        return userRepository.findAll();
    }
    @Override
    public void deleteUser(String idUser){
        userRepository.deleteById(idUser);
        
    }
    @Override
    public UserModel updateUser(String id, UserModel user){
        if(userRepository.existsById(id)){
            return userRepository.save(user);
        }else{
            return null;
        }
    }
    @Override
    public void createUserService(UserModel user) {
        String userId = user.getUserId();
        String usersName = user.getUserName();
        String usersPassword = user.getPassword();
        String userEmail = user.getUserEmail();
        int userAge = user.getUserAge();
        userRepository.createUser(userId,usersName,usersPassword,userEmail,userAge);
        
    }
    
    
}
