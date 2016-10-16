package com.mkrt4an.dao;

import com.mkrt4an.entity.CargoEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class CargoDao {

    private EntityManager em;

    public static void main(String[] args) {

    }

    public CargoDao() {}

    public CargoDao(EntityManager em){
        this.em = em;
    }

    // Find by id
    public CargoEntity findCargoById(int id) {
//        EntityManager em = getEntityManager();
        CargoEntity cg = em.find(CargoEntity.class, id);
//        em.close();
        return cg;
    }

    //Get all cargo list
    public List<CargoEntity> getAllCargo () {
//        EntityManager em = getEntityManager();
        List<CargoEntity> cgl = em.createQuery("select c from CargoEntity c", CargoEntity.class).getResultList();
//        em.close();
        return cgl;
    }

    //Create
    public void createCargo(CargoEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
        System.out.printf("New cargo is: %s\n", em.find(CargoEntity.class, cg.getId()));
//        em.close();
    }

    //Update
    public void updateCargo(CargoEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Delete
    public void deleteCargo (CargoEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
//        em.close();
    }

}


