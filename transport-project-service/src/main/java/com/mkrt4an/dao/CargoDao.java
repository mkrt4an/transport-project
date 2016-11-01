package com.mkrt4an.dao;

import com.mkrt4an.entity.CargoEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class CargoDao {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public CargoDao() {
    }

    public CargoDao(EntityManager em) {
        this.em = em;
    }

    // Find by id
    public CargoEntity findCargoById(int id) {
        return em.find(CargoEntity.class, id);
    }

    //Get all cargo list
    public List<CargoEntity> getAllCargo() {
        return em.createQuery("select c from CargoEntity c", CargoEntity.class).getResultList();
    }

    //Create
    public Integer createCargo(CargoEntity entity) {
        em.persist(entity);

        return entity.getId();
    }

    //Update
    public void updateCargo(CargoEntity entity) {
        em.persist(em.contains(entity) ? entity : em.merge(entity));
    }

    //Delete
    public void deleteCargo(CargoEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

}


