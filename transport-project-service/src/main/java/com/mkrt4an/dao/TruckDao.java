package com.mkrt4an.dao;

import com.mkrt4an.entity.TruckEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class TruckDao {

    private EntityManager em;

    public TruckDao() {
    }

    public TruckDao(EntityManager em) {
        this.em = em;
    }

    // Find by id
    public TruckEntity findTruckById(int id) {
        TruckEntity cg = em.find(TruckEntity.class, id);
        return cg;
    }

    //Get all cargo list
    public List<TruckEntity> getAllTrucks() {
        List<TruckEntity> cgl;
        cgl = em.createQuery("select c from TruckEntity c", TruckEntity.class).getResultList();
        return cgl;
    }

    //Create
    public void createTruck(TruckEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
    }

    //Update
    public void updateTruck(TruckEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
    }

    //Delete
    public void deleteTruck(TruckEntity cg) {
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
    }
}
