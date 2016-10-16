package com.mkrt4an.dao;

import com.mkrt4an.entity.RoutePointEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class RoutePointDao {

    private EntityManager em;

    public RoutePointDao(){}

    public RoutePointDao(EntityManager em){
        this.em = em;
    }

    // Find by id
    public RoutePointEntity findRoutePointById(int id) {
//        EntityManager em = getEntityManager();
        RoutePointEntity cg = em.find(RoutePointEntity.class, id);
//        em.close();
        return cg;
    }

    //Get all cargo list
    public List<RoutePointEntity> getAllRoutePoints () {
//        EntityManager em = getEntityManager();
        List<RoutePointEntity> cgl;
        cgl = em.createQuery("select c from RoutePointEntity c", RoutePointEntity.class).getResultList();
//        em.close();
        return cgl;
    }

    //Create
    public void createRoutePoint(RoutePointEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Update
    public void updateRoutePoint(RoutePointEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Delete
    public void deleteRoutePoint (RoutePointEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
//        em.close();
    }

}
