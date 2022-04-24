package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.model.ArtistModel;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.service.ArtistaService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ArtistaServiceImpl implements ArtistaService{
    
    @Autowired
    private ArtistRepository artistRepository;
    /*@Autowired
    private JdbcTemplate jdbcTemplate;
    */
    @Override
    public Iterable<ArtistModel> getArtist(){
        return artistRepository.findAll();
    }

    @Override
    public void deleteArtist(String idArtist){
        artistRepository.deleteById(idArtist);
        
    }

    @Override
    public ArtistModel updateArtist(String id, ArtistModel artist){
        if(artistRepository.existsById(id)){
            return artistRepository.save(artist);
        }else{
            return null;
        }
    }

    
}
