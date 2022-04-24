package com.example.demo.repository;

import com.example.demo.model.SongModel;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<SongModel,String> {
    @Query("SELECT * FROM SONG WHERE SONG.SONG_ID = :songId")
    public Iterable <SongModel> getSongById(String songId);

    @Modifying
    @Query("INSERT INTO SONG (SONG.SONG_ID,SONG.SONG_NAME,SONG.SONG_ARTIST,SONG.RELEASE_DATE,SONG.ALBUM,SONG.IMAGES) VALUES (artistId,artistName,artistGenres,artistImage)")
    public void insertArtist(String songId,String songName,String songArtist,String songDate,String songAlbum,String songImage);


    @Query("DELETE FROM SONG WHERE SONG.SONG_ID = :songId")
    public void deleteSong(String songId);
}
