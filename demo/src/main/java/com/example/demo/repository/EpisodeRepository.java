package com.example.demo.repository;

import com.example.demo.model.EpisodeModel;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.repository.CrudRepository;

public interface EpisodeRepository extends CrudRepository <EpisodeModel,String> {
    @Query("SELECT * FROM EPISODE WHERE EPISODE.EPISODE_ID = :episodeId")
    public Iterable <EpisodeModel> getEpisodeById(String episodeId);

    @Modifying
    @Query("INSERT INTO EPISODE (EPISODE.EPISODE_ID, EPISODE.EPISODE_NAME, EPISODE.PARTICIPANTS_NAME, EPISODE.IMAGES, EPISODE.TRACKS) VALUES (episodeId,episodeName,host,episodeImages,episodeTracks)")
    public void insertEpisode(String episodeId,String episodeName,String host,String episodeImage,String episodeTracks);

    @Query("DELETE FROM EPISODE WHERE EPISODE.EPISODE_ID = :episodeId")
    public void deleteEpisode(String episodeId);
}
