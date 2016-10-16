package com.mkrt4an.dao;

import com.mkrt4an.entity.DriverEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class DriverDao {

    private EntityManager em;

    public DriverDao(){}

    public DriverDao(EntityManager em){
        this.em = em;
    }

    // Find by id
    public DriverEntity findDriverById(int id) {
//        EntityManager em = getEntityManager();
        DriverEntity cg = em.find(DriverEntity.class, id);
//        em.close();
        return cg;
    }

    //Get all cargo list
    public List<DriverEntity> getAllDrivers () {
//        EntityManager em = getEntityManager();
        List<DriverEntity> cgl;
        cgl = em.createQuery("select c from DriverEntity c", DriverEntity.class).getResultList();
//        em.close();
        return cgl;
    }

    //Create
    public void createDriver(DriverEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Update
    public void updateDriver(DriverEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Delete
    public void deleteDriver (DriverEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
//        em.close();
    }

}
