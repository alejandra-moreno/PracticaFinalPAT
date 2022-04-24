package com.example.demo.service.implementation;

import com.example.demo.model.EpisodeModel;
import com.example.demo.repository.EpisodeRepository;
import com.example.demo.service.EpisodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeServiceImpl implements EpisodeService{

    @Autowired
    private EpisodeRepository episodeRepository;

    @Override
    public Iterable<EpisodeModel> getEpisode() {
        return episodeRepository.findAll();
    }

    @Override
    public void deleteEpisode(String idEpisode) {
        episodeRepository.deleteById(idEpisode);
        
    }

    @Override
    public EpisodeModel updateEpisode(String id, EpisodeModel episode) {
        if(episodeRepository.existsById(id)){
            return episodeRepository.save(episode);
        }else{
            return null;
        }
    }
    
}
