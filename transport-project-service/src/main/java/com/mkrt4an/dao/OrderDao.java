package com.mkrt4an.dao;

import com.mkrt4an.entity.OrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class OrderDao {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public OrderDao() {
    }

    public OrderDao(EntityManager em) {
        this.em = em;
    }

    // Find by id
    public OrderEntity findOrderById(int id) {
        return em.find(OrderEntity.class, id);
    }

    //Get all Order list
    public List<OrderEntity> getAllOrders() {
        return em.createQuery("select c from OrderEntity c", OrderEntity.class).getResultList();
    }

    //Create
    public Integer createOrder(OrderEntity entity) {
        em.persist(entity);

        return entity.getId();
    }

    //Update
    public void updateOrder(OrderEntity entity) {
        em.persist(em.contains(entity) ? entity : em.merge(entity));
    }

    //Delete
    public void deleteOrder(OrderEntity entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

}
