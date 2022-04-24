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


import com.example.demo.model.*;
import com.example.demo.repository.SongRepository;

@RestController
@RequestMapping("/api/v1")
@Service
public class SongController {
    @Autowired
    private SongRepository songRepostery;

    @GetMapping("/song")
    public ResponseEntity<Iterable<SongModel>> getSong(){

       Iterable<SongModel> response = songRepostery.findAll();
       return ResponseEntity.ok().body(response);
    }


    @PutMapping("/song/{id}/")
    public ResponseEntity<SongModel> updateSong(@PathVariable String id, @RequestBody SongModel song) {
        SongModel newSong = songRepostery.save(song);
        if (newSong == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newSong);
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<SongModel> deleteSong(@PathVariable String id) {
        songRepostery.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
