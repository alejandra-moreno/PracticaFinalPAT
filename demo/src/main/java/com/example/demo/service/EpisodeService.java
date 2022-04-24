package com.example.demo.service;

import com.example.demo.model.EpisodeModel;

public interface EpisodeService {
    Iterable<EpisodeModel> getEpisode();
    void deleteEpisode(String idEpisode);
    EpisodeModel updateEpisode(String id, EpisodeModel episode);
}
