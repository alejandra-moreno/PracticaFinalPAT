package com.example.demo.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongArtistDTO {
    String artistId;
    String artistName;
    String songName;
    String songAlbum;
    String songImage;
}
