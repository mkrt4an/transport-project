package com.mkrt4an.dao;

import com.mkrt4an.entity.OrderEntity;
import com.mkrt4an.entity.RoutePointEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class RoutePointDao {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public RoutePointDao() {
    }

    public RoutePointDao(EntityManager em) {
        this.em = em;
    }

    // Find by id
    public RoutePointEntity findRoutePointById(int id) {
        RoutePointEntity cg = em.find(RoutePointEntity.class, id);
        return cg;
    }

//    //Get order RP list by order id
//    public List<RoutePointEntity> getOrderRoutePointList(Integer orderId) {
//        TypedQuery query = em.createQuery("SELECT rp FROM RoutePointEntity rp WHERE rp.order = :orderId", RoutePointEntity.class);
//        query.setParameter("orderId", orderId);
//        List<RoutePointEntity> results = query.getResultList();
//
//        return results;
//
//    }

    //Get all cargo list
    public List<RoutePointEntity> getAllRoutePoints() {
        return em.createQuery("select c from RoutePointEntity c", RoutePointEntity.class).getResultList();
    }

    //Create
    public Integer createRoutePoint(RoutePointEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();

        return cg.getId();
    }

    //Update
    public Integer updateRoutePoint(RoutePointEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();

        return cg.getId();
    }

    //Delete
    public void deleteRoutePoint(RoutePointEntity cg) {
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
    }

}
