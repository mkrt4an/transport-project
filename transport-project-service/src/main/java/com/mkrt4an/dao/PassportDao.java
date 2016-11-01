package com.mkrt4an.dao;

import com.mkrt4an.entity.PassportEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class PassportDao {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public PassportDao() {
    }

    public PassportDao(EntityManager em) {
        this.em = em;
    }


    // Find by id
    public PassportEntity findById(int id) {
        return em.find(PassportEntity.class, id);
    }

    //Get all cargo list
    public List<PassportEntity> getAll() {
        return em.createQuery("select c from PassportEntity c", PassportEntity.class).getResultList();
    }

    //Create
    public void create(PassportEntity entity) {
        em.persist(entity);
    }

    //Update
    public void update(PassportEntity entity) {
        em.persist(em.contains(entity) ? entity : em.merge(entity));
    }

    //Delete
    public void delete(PassportEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

}

