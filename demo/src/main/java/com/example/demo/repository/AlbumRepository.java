package com.example.demo.repository;

import com.example.demo.model.AlbumModel;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<AlbumModel,String>{
    @Query("SELECT * FROM ALBUM WHERE ALBUM.ALBUM_ID = :albumId")
    public Iterable <AlbumModel> getAlbumById(String albumId);

    @Modifying
    @Query("INSERT INTO ALBUM (ALBUM.ALBUM_ID,ALBUM.ALBUM_NAME,ALBUM.ALBUM_ARTIST,ALBUM.RELEASE_DATE,ALBUM.TRACKS) VALUES (albumId,albumName,albumArtist,date,tracks)")
    public void insertAlbum(String albumId,String albumName,String albumArtist,String date,String tracks);


    @Query("DELETE FROM ALBUM WHERE ALBUM.ALBUM_ID = :albumId")
    public void deleteAlbum(String albumId);

}
