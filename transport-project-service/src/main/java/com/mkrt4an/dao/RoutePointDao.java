package com.mkrt4an.dao;

import com.mkrt4an.entity.OrderEntity;
import com.mkrt4an.entity.RoutePointEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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
        return em.find(RoutePointEntity.class, id);
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
    public Integer createRoutePoint(RoutePointEntity entity) {
        em.persist(entity);

        return entity.getId();
    }

    //Update
    public Integer updateRoutePoint(RoutePointEntity entity) {
        em.persist(em.contains(entity) ? entity : em.merge(entity));

        return entity.getId();
    }

    //Delete
    public void deleteRoutePoint(RoutePointEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

}
