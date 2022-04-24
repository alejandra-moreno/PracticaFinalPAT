package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AlbumModel;


public interface AlbumService {
    Iterable<AlbumModel> getAlbum();
    void deleteAlbum(String idAlbum);
    AlbumModel updateAlbum(String id, AlbumModel album);
    

}
