package com.example.demo.service.implementation;

import java.util.List;

import com.example.demo.model.ArtistModel;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.service.ArtistaService;
import com.example.demo.service.DTO.SongArtistDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Override
    public List<SongArtistDTO> getSongswithArtist() {
        
        return null;
    }

    //LEFT JOIN
	/*@Override
	public List<SongArtistDTO> getSongswithArtist() {

		String query =
				"""
    			SELECT ARTIST.ARTIST_ID, SONG.SONG_NAME, SONG.ALBUM, CUSTOMERS.GENRE
				FROM ARTIST
				LEFT JOIN SONG ON SONG.SONG_ARTIST=ARTIST.ARTIST_NAME;
				""";

		List<SongArtistDTO> orderList = jdbcTemplate.query(
				query,
				(rs, rowNum) ->
						new SongArtistDTO(
								rs.getString("ARTIST_ID"),
                                rs.getString("ARTIST_NAME"),
								rs.getString("SONG_NAME"),
								rs.getString("ALBUM"),
								rs.getString("GENRE") 
						)
		);

		return orderList;
	}*/
}
