package com.mkrt4an.service;

import com.mkrt4an.entity.OrderEntity;
import com.mkrt4an.entity.TruckEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class OrderService {

    //Find all orders
    public List<OrderEntity> findAllOrders (){
        List<OrderEntity> orderList = new ArrayList<OrderEntity>();
        for(OrderEntity od : orderList){
            orderList.add(od);
        }

        return orderList;
    }

    //Get list of truck avaible for order
    public List<TruckEntity> getAviableTrucksForOrder() {
        return null;
    }
}
