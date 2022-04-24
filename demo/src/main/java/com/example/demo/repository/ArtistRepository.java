package com.example.demo.repository;

import com.example.demo.model.*;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jdbc.repository.query.Modifying;

public interface ArtistRepository extends CrudRepository<ArtistModel, String>{
    @Query("SELECT * FROM ARTIST WHERE ARTIST.ARTIST_ID = :artistId")
    public Iterable <ArtistModel> getArtistById(String artistId);

    @Modifying
    @Query("INSERT INTO ARTIST (ARTIST.ARTIST_ID, ARTIST.ARTIST_NAME, ARTIST.GENRES, ARTIST.IMAGES) VALUES (artistId,artistName,artistGenres,artistImage)")
    public void insertArtist(String artistId,String artistName,String artistGenres,String artistImage);

    @Query("DELETE FROM ARTIST WHERE ARTIST.ARTIST_ID = :artistId")
    public void deleteArtist(String artistId);
}
