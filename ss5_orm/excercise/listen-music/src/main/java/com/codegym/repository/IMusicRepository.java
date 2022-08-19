package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {

    List<Music> findAll();

    void addMusic(Music music);

    void edit(Music music);

    void delete(int id);

    Music findById(int id);

}
