package com.example.demo.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlbumArtistDTO {
    String artistId;
    String artistName;
    String albumName;
    String tracks;
}
