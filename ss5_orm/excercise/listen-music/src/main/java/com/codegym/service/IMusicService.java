package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicService {

    List<Music> findAll();

    void addProduct(Music product);

    void edit(Music product);

    void delete(int id);

    Music findById(int id);

}
