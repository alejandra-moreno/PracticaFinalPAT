package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ArtistModel;
import com.example.demo.service.DTO.SongArtistDTO;

public interface ArtistaService {
    Iterable<ArtistModel> getArtist();
    void deleteArtist(String idArtist);
    ArtistModel updateArtist(String id, ArtistModel artist);
    List<SongArtistDTO> getSongswithArtist();
}
