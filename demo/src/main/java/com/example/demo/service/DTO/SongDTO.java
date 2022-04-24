package com.example.demo.service.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SongDTO {
    String songId;
    String songName;
    String songArtist;
    LocalDate songDate;
    String songAlbum;
    String songImage;
}
