package com.mkrt4an.dao;

import com.mkrt4an.entity.DriverEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class DriverDao {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public DriverDao() {
    }

    public DriverDao(EntityManager em) {
        this.em = em;
    }

    // Find by id
    public DriverEntity findDriverById(int id) {
        return em.find(DriverEntity.class, id);
    }

    //Get all cargo list
    public List<DriverEntity> getAllDrivers() {
        return em.createQuery("select c from DriverEntity c", DriverEntity.class).getResultList();
    }

    //Create
    public void createDriver(DriverEntity entity) {
        em.persist(entity);
    }

    //Update
    public void updateDriver(DriverEntity entity) {
        em.persist(em.contains(entity) ? entity : em.merge(entity));
    }

    //Delete
    public void deleteDriver(DriverEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

}
