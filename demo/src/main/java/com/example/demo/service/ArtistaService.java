package com.example.demo.service;

import com.example.demo.model.ArtistModel;

public interface ArtistaService {
    Iterable<ArtistModel> getArtist();
    void deleteArtist(String idArtist);
    ArtistModel updateArtist(String id, ArtistModel artist);
   
}
