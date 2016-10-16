package com.mkrt4an.dao;

import com.mkrt4an.entity.CityEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */


public class CityDao {
    private EntityManager em;

    CityDao(){}

    public CityDao(EntityManager em){
        this.em = em;
    }


    // Find by id
    public CityEntity findCityById(int id) {
//        EntityManager em = getEntityManager();
        CityEntity cg = em.find(CityEntity.class, id);
//        em.close();
        return cg;
    }

    //Get all Order list
    public List<CityEntity> getAllCities () {
//        EntityManager em = getEntityManager();
        List<CityEntity> cgl;
        cgl = em.createQuery("select c from CityEntity c", CityEntity.class).getResultList();
//        em.close();
        return cgl;
    }

    //Create
    public void createCity(CityEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
        System.out.printf("New City is: %s\n", em.find(CityEntity.class, cg.getId()));
//        em.close();
    }

    //Update
    public void updateCity(CityEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Delete
    public void deleteCity (CityEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
//        em.close();
    }



}