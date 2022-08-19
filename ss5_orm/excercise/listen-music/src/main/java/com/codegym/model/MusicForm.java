package com.codegym.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table
public class MusicForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "song_name")
    private String name;
    private String singer;
    @Column(name = "song_type")
    private String songType;
    private MultipartFile link;

    public MusicForm() {
    }


    public MusicForm(int id, String name, String singer, String songType, MultipartFile link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.songType = songType;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }
}
