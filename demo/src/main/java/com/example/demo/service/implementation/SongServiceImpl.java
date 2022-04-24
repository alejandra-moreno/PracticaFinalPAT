package com.example.demo.service.implementation;

import com.example.demo.model.SongModel;
import com.example.demo.repository.SongRepository;
import com.example.demo.service.SongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository songRepository;

    @Override
    public Iterable<SongModel> getSong(){
        return songRepository.findAll();
    }

    @Override
    public void deleteSong(String idSong){
        songRepository.deleteById(idSong);
    }

    @Override
    public SongModel updateAlbum(String id, SongModel song){
        if(songRepository.existsById(id)){
            return songRepository.save(song);
        }else{
            return null;
        }
    }
}
