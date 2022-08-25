package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepositry;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepositry iMusicRepositry;

    @Override
    public List<Music> findAll() {
        return iMusicRepositry.findAll();
    }

    @Override
    public void save(Music music) {
        iMusicRepositry.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepositry.findById(id).orElse(null);
    }
}
