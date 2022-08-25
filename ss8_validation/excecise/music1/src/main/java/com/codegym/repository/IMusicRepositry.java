package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepositry extends JpaRepository<Music, Integer> {
}
