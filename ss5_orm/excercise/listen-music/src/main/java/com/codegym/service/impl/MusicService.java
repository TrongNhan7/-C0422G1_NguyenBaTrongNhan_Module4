package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void addProduct(Music product) {
        iMusicRepository.addProduct(product);
    }

    @Override
    public void edit(Music product) {
        iMusicRepository.edit(product);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

}
