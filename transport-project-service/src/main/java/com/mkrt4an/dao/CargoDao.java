package com.mkrt4an.dao;

import com.mkrt4an.entity.CargoEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

//@Stateless
public class CargoDao {
//    @PersistenceContext(unitName = "DataSourceEx")
    private EntityManager em;

    public static void main(String[] args) {

    }

    public CargoDao() {
    }

    public CargoDao(EntityManager em) {
        this.em = em;
    }

    // Find by id
    public CargoEntity findCargoById(int id) {
        CargoEntity cg = em.find(CargoEntity.class, id);
        return cg;
    }

    //Get all cargo list
    public List<CargoEntity> getAllCargo() {
        List<CargoEntity> cgl = em.createQuery("select c from CargoEntity c", CargoEntity.class).getResultList();
        return cgl;
    }

    //Create
    public Integer createCargo(CargoEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();

        return cg.getId();
    }

    //Update
    public void updateCargo(CargoEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
    }

    //Delete
    public void deleteCargo(CargoEntity cg) {
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
    }

}


