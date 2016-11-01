package com.mkrt4an.dao;

import com.mkrt4an.entity.CityEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */


public class CityDao {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public CityDao() {
    }

    public CityDao(EntityManager em) {
        this.em = em;
    }


    // Find by id
    public CityEntity findCityById(int id) {
        CityEntity cg = em.find(CityEntity.class, id);
        return cg;
    }

    //Get all Order list
    public List<CityEntity> getAllCities() {
//        EntityManager em = getEntityManager();
        List<CityEntity> cgl;
        cgl = em.createQuery("select c from CityEntity c", CityEntity.class).getResultList();
//        em.close();
        return cgl;
    }

    //Create
    public void createCity(CityEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
        System.out.printf("New City is: %s\n", em.find(CityEntity.class, cg.getId()));
    }

    //Update
    public void updateCity(CityEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
    }

    //Delete
    public void deleteCity(CityEntity cg) {
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
    }


}