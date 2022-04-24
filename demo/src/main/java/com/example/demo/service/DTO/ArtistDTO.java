package com.example.demo.service.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArtistDTO {
    String artistId;
    String artistName;
    String artistGenres;
    String artistImage;
}
