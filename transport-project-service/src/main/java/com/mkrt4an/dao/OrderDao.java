package com.mkrt4an.dao;

import com.mkrt4an.entity.OrderEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class OrderDao {

    private EntityManager em;

    public OrderDao(){}

    public OrderDao(EntityManager em){
        this.em = em;
    }

    // Find by id
    public OrderEntity findOrderById(int id) {
//        EntityManager em = getEntityManager();
        OrderEntity cg = em.find(OrderEntity.class, id);
//        em.close();
        return cg;
    }

    //Get all Order list
    public List<OrderEntity> getAllOrders () {
//        EntityManager em = getEntityManager();
        List<OrderEntity> cgl;
        cgl = em.createQuery("select c from OrderEntity c", OrderEntity.class).getResultList();
//        em.close();
        return cgl;
    }

    //Create
    public void createOrder(OrderEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Update
    public void updateOrder(OrderEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
//        em.close();
    }

    //Delete
    public void deleteOrder (OrderEntity cg){
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
//        em.close();
    }

}
