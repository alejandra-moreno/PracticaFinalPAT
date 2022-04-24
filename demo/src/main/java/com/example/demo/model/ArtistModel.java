package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Value;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("ARTIST")

public class ArtistModel {
    
    private @Column("ARTIST_ID") @Id String artistId;
	private @Column("ARTIST_NAME") String artistName;
    private @Column("GENRES") String artistGenres;
    private @Column("IMAGES") String artistImage;
}
