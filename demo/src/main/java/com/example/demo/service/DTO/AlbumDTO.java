package com.example.demo.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlbumDTO {
    String artistId;
    String albumId;
    String artistName;
    String albumName;
    String tracks;
}
