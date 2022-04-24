package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.AlbumModel;
import com.example.demo.repository.AlbumRepository;

@RestController
@RequestMapping("/api/v1")

public class AlbumController {
    @Autowired
    private AlbumRepository albumRepostery;

    @GetMapping("/album")
    public ResponseEntity<Iterable<AlbumModel>> getAlbum(){

       Iterable<AlbumModel> response = albumRepostery.findAll();
       return ResponseEntity.ok().body(response);
    }


    @PutMapping("/album/{id}/")
    public ResponseEntity<AlbumModel> updateAlbum(@PathVariable String id, @RequestBody AlbumModel album) {
        AlbumModel newAlbum = albumRepostery.save(album);
        if (newAlbum == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newAlbum);
    }

    @DeleteMapping("/album/{id}")
    public ResponseEntity<AlbumModel> deleteAlbum(@PathVariable String id) {
        albumRepostery.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
