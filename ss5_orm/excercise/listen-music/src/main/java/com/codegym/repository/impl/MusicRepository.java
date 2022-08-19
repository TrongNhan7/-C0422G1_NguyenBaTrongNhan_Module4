package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    private static final String SELECT_ALL_PRODUCT = "select m from Music as m";
    private static final String SELECT_BY_ID = "select m from Music as m where m.id = :id";

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery(SELECT_ALL_PRODUCT, Music.class);
        return query.getResultList();
    }

    @Override
    public void addMusic(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void edit(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Music.class, id));
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery(SELECT_BY_ID, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
