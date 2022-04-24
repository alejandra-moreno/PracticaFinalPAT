package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/api/v1")

public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepostery;

    UserModel user;

    /*@GetMapping("/clientesGET")
    public UserModel getCliente(){
        return user;
    }

    @PostMapping("/clientesPOST")
    public void postCliente(@RequestBody UserModel user){
        this.user = user;
    }
    */

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModel>> getUser(){

       Iterable<UserModel> response = userRepostery.findAll();
       return ResponseEntity.ok().body(response);
    }

    //Insertar un nuevo usuario
    //Meter un usuario
    @PostMapping("/users")
    public ResponseEntity<String> createUserById(
        @RequestBody UserModel user,
        BindingResult bindingResult){

        if(bindingResult.hasErrors()){
        return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }else{
            userService.createUserService(user);
        return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }

  }

    //Actualizar información de un usuario
    @PutMapping("/users/{id}/")
    public ResponseEntity<UserModel> updateUser(@PathVariable String id, @RequestBody UserModel user) {
        UserModel newUser = userRepostery.save(user);
        if (newUser == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newUser);
    }

    //Eliminar a un usuario 
    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable String id) {
        userRepostery.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    

}
