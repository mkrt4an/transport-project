package com.mkrt4an.dao;

import com.mkrt4an.entity.DriverEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class DriverDao {

    private EntityManager em;

    public DriverDao() {
    }

    public DriverDao(EntityManager em) {
        this.em = em;
    }

    // Find by id
    public DriverEntity findDriverById(int id) {
        DriverEntity cg = em.find(DriverEntity.class, id);
        return cg;
    }

    //Get all cargo list
    public List<DriverEntity> getAllDrivers() {
        List<DriverEntity> cgl;
        cgl = em.createQuery("select c from DriverEntity c", DriverEntity.class).getResultList();
        return cgl;
    }

    //Create
    public void createDriver(DriverEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
    }

    //Update
    public void updateDriver(DriverEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
    }

    //Delete
    public void deleteDriver(DriverEntity cg) {
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
    }

}
