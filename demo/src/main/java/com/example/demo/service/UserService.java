package com.example.demo.service;

import com.example.demo.model.UserModel;

public interface UserService {
    
    Iterable<UserModel> getUser();
    void deleteUser(String idUser);
    UserModel updateUser(String id, UserModel user);
    void createUserService(UserModel user);
}
