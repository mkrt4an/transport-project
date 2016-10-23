package com.mkrt4an.service;


import com.mkrt4an.dao.*;
import com.mkrt4an.entity.*;

import java.util.ArrayList;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 02.10.2016.
 */

public class OrderService {

    // Exceptions
//    public class NoSuitableDrversException extends Exception {
//        NoSuitableDrversException() {
//        }
//    }

//    public class NoSuitableTruckException extends Exception {
//        NoSuitableTruckException() {
//        }
//    }

    //Find by id
    public OrderEntity findById(String id) {
        OrderDao orderDao = new OrderDao(getEntityManager());
        return orderDao.findOrderById(Integer.parseInt(id));
    }

    //Find by id
    public OrderEntity findById(Integer id) {
        OrderDao orderDao = new OrderDao(getEntityManager());
        return orderDao.findOrderById(id);
    }

    // Update order
    public void update(OrderEntity orderEntity) {
        OrderDao orderDao = new OrderDao(getEntityManager());
        orderDao.updateOrder(orderEntity);
    }

    //Find all orders
    public List<OrderEntity> findAll() {
        OrderDao orderDao = new OrderDao(getEntityManager());
        return orderDao.getAllOrders();
    }

    // Get truck suitable for this order
    public TruckEntity getSuitableTruck(OrderEntity orderEntity)
//            throws NoSuitableTruckException

    {

        TruckDao truckDao = new TruckDao(getEntityManager());

        List<TruckEntity> suitableTrucks = new ArrayList<>();

        List<TruckEntity> allTrucks = truckDao.getAllTrucks();

        for (TruckEntity truckEntity : allTrucks) {
            if (
//                    (orderEntity.getRoutePointList().get(0).getCargo().getWeight() <= truckEntity.getCapasity())&&
                    truckEntity.getStatus() == 1 &&
                            truckEntity.getOrders() == null) {
                suitableTrucks.add(truckEntity);
            }
        }

        return  suitableTrucks.isEmpty() ? null : suitableTrucks.get(0);
    }


    //Get list of truck avaible for this order
    public List<TruckEntity> getSuitableTruckList(OrderEntity orderEntity)
//            throws NoSuitableTruckException
    {

        TruckDao truckDao = new TruckDao(getEntityManager());

        List<TruckEntity> suitableTrucks = new ArrayList<>();

        List<TruckEntity> allTrucks = truckDao.getAllTrucks();

        for (TruckEntity truckEntity : allTrucks) {
            if (
//                    (orderEntity.getRoutePointList().get(0).getCargo().getWeight() <= truckEntity.getCapasity())&&
                    truckEntity.getStatus() == 1 &&
                            truckEntity.getOrders() == null) {
                suitableTrucks.add(truckEntity);
            }
        }

        return suitableTrucks;
    }


    // Get driver suitable for this order
    public DriverEntity getSuitableDriver(OrderEntity orderEntity)
//            throws NoSuitableDrversException

    {

        DriverDao driverDao = new DriverDao(getEntityManager());

        List<DriverEntity> suitableDrivetList = new ArrayList<>();

        List<DriverEntity> driverEntityList = driverDao.getAllDrivers();

        for (DriverEntity driverEntity : driverEntityList) {
            if (driverEntity.getOrder() == null && driverEntity.getCurrentCity() == orderEntity.getCurrentTruck().getCurrentCity()) {
                suitableDrivetList.add(driverEntity);
            }
        }

        return suitableDrivetList.isEmpty() ? null : suitableDrivetList.get(0);
    }


    // Get driver list suitable for this order
    public List<DriverEntity> getSuitableDriverList(OrderEntity orderEntity)
//            throws NoSuitableDrversException

    {

        DriverDao driverDao = new DriverDao(getEntityManager());

        List<DriverEntity> suitableDrivetList = new ArrayList<>();

        List<DriverEntity> driverEntityList = driverDao.getAllDrivers();

        for (DriverEntity driverEntity : driverEntityList) {
            if (driverEntity.getOrder() == null
                    && orderEntity.getCurrentTruck().getDutySize() > suitableDrivetList.size()
                    && driverEntity.getCurrentCity() == orderEntity.getCurrentTruck().getCurrentCity()
                    ) {
                suitableDrivetList.add(driverEntity);
//                driverEntity.setCurrentTruck(orderEntity.getCurrentTruck()); //TODO
            }
        }

        return suitableDrivetList;
    }


//    // Add new order by uid, cargoEntity and CityEntity
//    public Integer addOrder(Integer uid, Integer cargoEntityId, Integer fromCityId, Integer toCityId) {
//
//        // List of routrPoint which we transfer to orderEntity constructor as argument
//        List<RoutePointEntity> routePointEntityList = new ArrayList<RoutePointEntity>();
//
//        // Get DAO
//        OrderDao orderDao = new OrderDao(getEntityManager());
//        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
//        CityDao cityDao = new CityDao(getEntityManager());
//        CargoDao cargoDao = new CargoDao(getEntityManager());
//
//        // Get entities
//        CargoEntity cargoEntity = cargoDao.findCargoById(cargoEntityId);
//        CityEntity fromCityEntity = cityDao.findCityById(fromCityId);
//        CityEntity toCityEntity = cityDao.findCityById(toCityId);
//
//        // City, from which we are taking
//        RoutePointEntity routePointEntity = new RoutePointEntity(fromCityEntity, cargoEntity, 0);
//        Integer i = routePointDao.createRoutePoint(routePointEntity);
//        routePointEntityList.add(routePointDao.findRoutePointById(i));
//
//        // City, in which we are taking
//        routePointEntity = new RoutePointEntity(toCityEntity, cargoEntity, 1);
//        i = routePointDao.createRoutePoint(routePointEntity);
//        routePointEntityList.add(routePointDao.findRoutePointById(i));
//
//        //Create order entity
//        OrderEntity orderEntity = new OrderEntity(uid, 0, routePointEntityList);
//
//        //set order id to routePoints
//        orderEntity.assignRoutePointList(routePointEntityList);
//
//        // return new order id
//        return orderDao.createOrder(orderEntity);
//    }

    public void deleteOrder(OrderEntity orderEntity) {
        OrderDao orderDao = new OrderDao(getEntityManager());
        orderDao.deleteOrder(orderEntity);
    }

    public void deleteById(Integer Id) {
        OrderDao orderDao = new OrderDao(getEntityManager());
        OrderEntity orderEntity = orderDao.findOrderById(Id);
        orderDao.deleteOrder(orderEntity);
    }

    public void deleteById(String Id) {
        OrderDao orderDao = new OrderDao(getEntityManager());
        OrderEntity orderEntity = orderDao.findOrderById(Integer.parseInt(Id));
        orderDao.deleteOrder(orderEntity);
    }


    // Add new order by uid, cargoEntity and CityEntity
    public Integer addOrder() {

        // Get DAO
        OrderDao orderDao = new OrderDao(getEntityManager());

        //Create order entity
        OrderEntity orderEntity = new OrderEntity();

        // return new order id
        return orderDao.createOrder(orderEntity);
    }

}
