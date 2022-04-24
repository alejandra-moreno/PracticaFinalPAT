package com.example.demo.service;

import com.example.demo.model.SongModel;

public interface SongService {
    Iterable<SongModel> getSong();
    void deleteSong(String idSong);
    SongModel updateAlbum(String id, SongModel song);
}
