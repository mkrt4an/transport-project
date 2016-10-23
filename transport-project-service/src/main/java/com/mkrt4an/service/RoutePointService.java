package com.mkrt4an.service;

import com.mkrt4an.dao.CargoDao;
import com.mkrt4an.dao.CityDao;
import com.mkrt4an.dao.OrderDao;
import com.mkrt4an.dao.RoutePointDao;
import com.mkrt4an.entity.CargoEntity;
import com.mkrt4an.entity.CityEntity;
import com.mkrt4an.entity.OrderEntity;
import com.mkrt4an.entity.RoutePointEntity;

import java.util.ArrayList;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 02.10.2016.
 */

public class RoutePointService {

    public Integer AddRoutePointBlank(Integer cityId, Integer orderId) {

        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
        CityDao cityDao = new CityDao(getEntityManager());
        OrderDao orderDao = new OrderDao(getEntityManager());

        RoutePointEntity routePoint = new RoutePointEntity(cityDao.findCityById(cityId), orderDao.findOrderById(orderId));

//        routePoint.assignCargoToLoadList(cargoToLoad);
//        routePoint.assignCargoToDeliverList(cargoToDeliver);

        return routePointDao.createRoutePoint(routePoint);
    }


    public Integer AddRoutePoint(List<CargoEntity> cargoToLoad, List<CargoEntity> cargoToDeliver,
                                 Integer ordinal, CityEntity city, OrderEntity order) {

        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
        OrderDao orderDao = new OrderDao(getEntityManager());

        RoutePointEntity routePoint = new RoutePointEntity(cargoToLoad,
                cargoToDeliver,
                ordinal,
                city,
                order
        );


//        List<RoutePointEntity> routePointEntityListRes;
//
//        Integer i = 0;
//        for(RoutePointEntity routePointEntity : order.getRoutePointList()) {
//            routePointEntity.setOrdinal(i++);
//        }
//         routePointEntityListRes


        routePoint.assignCargoToLoadList(cargoToLoad);
//        routePoint.assignCargoToDeliverList(cargoToDeliver);

        return routePointDao.createRoutePoint(routePoint);
    }


    public Integer AddCargoToLoadingList(Integer orderId, Integer routePointId,
                                         String cargoName, Integer cargoWeight) {
        //DAO
        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
        CargoDao cargoDao = new CargoDao(getEntityManager());

        //Creare CargoEntity
        CargoEntity cargoEntity = new CargoEntity(cargoName, cargoWeight, 0);
        cargoDao.createCargo(cargoEntity);

        RoutePointEntity routePointEntity = routePointDao.findRoutePointById(routePointId);

        List<CargoEntity> cargoToLoadList;

        if (routePointEntity.getCargoToLoadList() != null) {
            cargoToLoadList = routePointEntity.getCargoToLoadList();
            cargoToLoadList.add(cargoEntity);
        } else {
            cargoToLoadList = new ArrayList<>();
            cargoToLoadList.add(cargoEntity);
        }

        routePointEntity.setCargoToLoadList(cargoToLoadList);
        routePointEntity.assignCargoToLoadList(cargoToLoadList);

        routePointDao.updateRoutePoint(routePointEntity);

        return cargoEntity.getId();
    }


    public Integer AddCargoToDeliverList(Integer orderId, Integer routePointId,
                                         Integer cargoId) {
        //DAO
        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
        CargoDao cargoDao = new CargoDao(getEntityManager());

        RoutePointEntity routePointEntity = routePointDao.findRoutePointById(routePointId);
        CargoEntity cargoEntity = cargoDao.findCargoById(cargoId);

        List<CargoEntity> cargoToDeliverList;

        if (routePointEntity.getCargoToLoadList() != null) {
            cargoToDeliverList = routePointEntity.getCargoToLoadList();
            cargoToDeliverList.add(cargoEntity);
        } else {
            cargoToDeliverList = new ArrayList<>();
            cargoToDeliverList.add(cargoEntity);
        }

        routePointEntity.setCargoToDeliverList(cargoToDeliverList);
        routePointEntity.assignCargoToDeliverList(cargoToDeliverList);

        routePointDao.updateRoutePoint(routePointEntity);

        return cargoEntity.getId();
    }


    public Integer updateRoutePoint(RoutePointEntity routePoint,
                                    List<CargoEntity> cargoToLoad,
                                    List<CargoEntity> cargoToDeliver,
                                    Integer ordinal,
                                    CityEntity city,
                                    OrderEntity order) {

        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());

        routePoint.setCargoToLoadList(cargoToLoad);
        routePoint.setCargoToLoadList(cargoToDeliver);
        routePoint.setOrdinal(ordinal);
        routePoint.setCity(city);
        routePoint.setOrder(order);


        return routePointDao.updateRoutePoint(routePoint);
    }

    public RoutePointEntity findById(String id) {
        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
        return routePointDao.findRoutePointById(Integer.parseInt(id));
    }

    public RoutePointEntity findById(Integer id) {
        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
        return routePointDao.findRoutePointById(id);
    }


    //Find all orders
    public List<RoutePointEntity> findAll() {
        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
        return routePointDao.getAllRoutePoints();
    }


}
