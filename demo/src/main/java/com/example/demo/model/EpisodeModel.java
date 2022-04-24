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
@Table("EPISODE")

public class EpisodeModel{
    private @Column("EPISODE_ID") @Id String episodeId;
	private @Column("EPISODE_NAME") String episodeName;
	private @Column("PARTICIPANTS_NAME") String host;
	private @Column("IMAGES") String episodeImage;
	private @Column("TRACKS") String episodeTracks;
}

