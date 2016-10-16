package com.mkrt4an.dao;

import com.mkrt4an.entity.TruckEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class TruckDao {

    private EntityManager em;

    public TruckDao(){}

    public TruckDao(EntityManager em){
        this.em = em;
    }

    // Find by id
    public TruckEntity findTruckById(int id) {
//        EntityManager em = getEntityManager();
        TruckEntity cg = em.find(TruckEntity.class, id);
//        em.close();
        return cg;
    }

    //Get all cargo list
    public List<TruckEntity> getAllTrucks () {
//        EntityManager em = getEntityManager();
        List<TruckEntity> cgl;
        cgl = em.createQuery("select c from TruckEntity c", TruckEntity.class).getResultList();
//        em.close();
        return cgl;
    }

    //Create
    public void createTruck(TruckEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Update
    public void updateTruck(TruckEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Delete
    public void deleteTruck (TruckEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
//        em.close();
    }
}
