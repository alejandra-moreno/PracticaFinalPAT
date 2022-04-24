package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.model.AlbumModel;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.service.AlbumService;

//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;
    /*@Autowired
    private JdbcTemplate jdbcTemplate;*/
    @Override
    public Iterable<AlbumModel> getAlbum(){
        return albumRepository.findAll();
    }


    @Override
    public void deleteAlbum(String idAlbum) {
        albumRepository.deleteById(idAlbum);
        
    }


    @Override
    public AlbumModel updateAlbum(String id, AlbumModel album) {
        if(albumRepository.existsById(id)){
            return albumRepository.save(album);
        }else{
            return null;
        }
    }
        
    
}
