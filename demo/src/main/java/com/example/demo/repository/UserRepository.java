package com.example.demo.repository;


import com.example.demo.model.UserModel;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel,String>{
    @Query("SELECT * FROM USER WHERE USER.USER_ID = :userId")
    public Iterable <UserModel> getUserById(String userId);

    @Query("UPDATE USER SET USER.USERS_NAME= :usersName WHERE USER.USER_ID = :userId")
    public UserModel updateUserName(String usersName,String userId);

    @Query("UPDATE USER SET USER.USERS_PASSWORD= :usersPassword WHERE USER.USER_ID = :userId")
    public UserModel updateUserPassword(String usersPassword,String userId);

    @Modifying
    @Query("INSERT INTO USER (USER_ID, USERS_NAME, USERS_PASSWORD, USER_EMAIL, USER_AGE) VALUES (:userId,:usersName,:usersPassword,:userEmail,:userAge)")
    public void createUser(String userId,String usersName,String usersPassword,String userEmail,int userAge);

    @Query("DELETE FROM USER WHERE USER.USER_ID = :userId")
    public void deleteUser(String userId);
}
