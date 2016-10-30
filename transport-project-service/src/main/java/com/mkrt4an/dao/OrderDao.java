package com.mkrt4an.dao;

import com.mkrt4an.entity.OrderEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class OrderDao {

    private EntityManager em;

    public OrderDao() {
    }

    public OrderDao(EntityManager em) {
        this.em = em;
    }

    // Find by id
    public OrderEntity findOrderById(int id) {
        OrderEntity cg = em.find(OrderEntity.class, id);
        return cg;
    }

    //Get all Order list
    public List<OrderEntity> getAllOrders() {
        List<OrderEntity> cgl;
        cgl = em.createQuery("select c from OrderEntity c", OrderEntity.class).getResultList();
        return cgl;
    }

    //Create
    public Integer createOrder(OrderEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();

        return cg.getId();
    }

    //Update
    public void updateOrder(OrderEntity cg) {
        em.getTransaction().begin();
        em.persist(cg);
        em.getTransaction().commit();
    }

    //Delete
    public void deleteOrder(OrderEntity cg) {
        em.getTransaction().begin();
        em.remove(cg);
        em.getTransaction().commit();
    }

}
