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


import com.example.demo.model.ArtistModel;
import com.example.demo.repository.ArtistRepository;

@RestController
@RequestMapping("/api/v1")

public class AristController {
    @Autowired
    private ArtistRepository artistRepostery;

    @GetMapping("/artist")
    public ResponseEntity<Iterable<ArtistModel>> getArtist(){

       Iterable<ArtistModel> response = artistRepostery.findAll();
       return ResponseEntity.ok().body(response);
    }

    @PutMapping("/artist/{id}/")
    public ResponseEntity<ArtistModel> updateArtist(@PathVariable String id, @RequestBody ArtistModel artist) {
        ArtistModel newArtist = artistRepostery.save(artist);
        if (newArtist == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newArtist);
    }

    @DeleteMapping("/artist/{id}")
    public ResponseEntity<ArtistModel> deleteArtist(@PathVariable String id) {
        artistRepostery.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
