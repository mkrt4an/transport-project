package com.mkrt4an.dao;

import com.mkrt4an.entity.PassportEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 28.09.2016.
 */

public class PassportDao {
    private EntityManager em;

    public PassportDao (){}

    public PassportDao(EntityManager em){
        this.em = em;
    }


    // Find by id
    public PassportEntity findById(int id) {
        PassportEntity cg = em.find(PassportEntity.class, id);
        return cg;
    }

    //Get all cargo list
    public List<PassportEntity> getAll () {
        List<PassportEntity> cgl;
        cgl = em.createQuery("select c from PassportEntity c", PassportEntity.class).getResultList();
        return cgl;
    }

    //Create
    public void create(PassportEntity cg){
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
        System.out.printf("New User is: %s\n", em.find(PassportEntity.class, cg.getId()));

    }

    //Update
    public void update(PassportEntity cg){
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
        System.out.printf("New user is: %s\n", em.find(PassportEntity.class, cg.getId()));
    }

    //Delete
    public void delete (PassportEntity cg){
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
    }

}

