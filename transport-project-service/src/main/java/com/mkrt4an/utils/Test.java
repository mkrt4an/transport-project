package com.mkrt4an.utils;


import com.mkrt4an.dao.RoutePointDao;
import com.mkrt4an.entity.CargoEntity;
import com.mkrt4an.entity.OrderEntity;
import com.mkrt4an.service.*;

import java.util.ArrayList;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

//import org.apache.logging.log4j.LogManager;

/**
 * Created by 123 on 05.10.2016.
 */

//TODO write test for service classes

public class Test {

//    static final Logger logger = LogManager.getLogger(Test.class.getName());

    public static void main(String[] args) {

//        // DAO
//        CargoDao cargo = new CargoDao(getEntityManager());
//        TruckDao truck = new TruckDao(getEntityManager());
//        DriverDao driver = new DriverDao(getEntityManager());
//        OrderDao order = new OrderDao(getEntityManager());
//        CityDao city = new CityDao(getEntityManager());
        RoutePointDao routePointDao = new RoutePointDao(getEntityManager());
//        UserDao user = new UserDao(getEntityManager());
//        PassportDao passport = new PassportDao(getEntityManager());

        // Services
        TruckService truckService = new TruckService();
        RoutePointService routePointService = new RoutePointService();
        CargoService cargoService = new CargoService();
        CityService cityService = new CityService();
        OrderService orderService = new OrderService();

        // Create new order
        Integer orderId = orderService.addOrder();

        // first rp
        List<CargoEntity> cargoToLoadRp1 = new ArrayList<CargoEntity>();
        cargoToLoadRp1.add(cargoService.findById(1));
        cargoToLoadRp1.add(cargoService.findById(2));

        List<CargoEntity> cargoToDeliverRp1 = new ArrayList<CargoEntity>();
//        cargoToDeliverRp1.add(cargoService.findById(3));
//        cargoToDeliverRp1.add(cargoService.findById(4));

        //second rp
        List<CargoEntity> cargoToLoadRp2 = new ArrayList<CargoEntity>();
        cargoToLoadRp2.add(cargoService.findById(3));
        cargoToLoadRp2.add(cargoService.findById(4));

        List<CargoEntity> cargoToDeliverRp2 = new ArrayList<CargoEntity>();
        cargoToDeliverRp2.add(cargoService.findById(1));
        cargoToDeliverRp2.add(cargoService.findById(2));

        //third rp
        List<CargoEntity> cargoToLoadRp3 = new ArrayList<CargoEntity>();
        cargoToLoadRp3.add(cargoService.findById(5));
        cargoToLoadRp3.add(cargoService.findById(6));

        List<CargoEntity> cargoToDeliverRp3 = new ArrayList<CargoEntity>();
        cargoToDeliverRp3.add(cargoService.findById(3));
        cargoToDeliverRp3.add(cargoService.findById(4));

        //fourth rp
        List<CargoEntity> cargoToLoadRp4 = new ArrayList<CargoEntity>();
//        cargoToLoadRp3.add(cargoService.findById(3));
//        cargoToLoadRp3.add(cargoService.findById(4));

        List<CargoEntity> cargoToDeliverRp4 = new ArrayList<CargoEntity>();
        cargoToDeliverRp4.add(cargoService.findById(5));
        cargoToDeliverRp4.add(cargoService.findById(6));


        //Add rp to order
       // Add first rp
        routePointService.AddRoutePoint(cargoToLoadRp1, cargoToDeliverRp1, 1,
                cityService.findById(1), orderService.findById(orderId));

        // Add second rp
        routePointService.AddRoutePoint(cargoToLoadRp2, cargoToDeliverRp2, 2,
                cityService.findById(2), orderService.findById(orderId));

        // Add third rp
        routePointService.AddRoutePoint(cargoToLoadRp3, cargoToDeliverRp3, 3,
                cityService.findById(3), orderService.findById(orderId));

        // Add fouth rp
        routePointService.AddRoutePoint(cargoToLoadRp4, cargoToDeliverRp4, 4,
                cityService.findById(4), orderService.findById(orderId));


        //Set suitable truck
        OrderEntity orderEntity = orderService.findById(orderId);

        orderEntity.setCurrentTruck(orderService.getSuitableTruck(orderEntity));
        orderEntity.setCurrentTruck(truckService.findById(""+ 1));
        orderService.update(orderEntity);

//        System.out.println(orderEntity);

        //Set suitable driver
        orderEntity = orderService.findById(orderId);

        orderEntity.setDriverList(orderService.getSuitableDriverList(orderEntity));
        orderEntity.assignDriverList(orderService.getSuitableDriverList(orderEntity));
        orderService.update(orderEntity);

        // Get order route point list
        System.out.println("***************** ORDER RP *********************");
        System.out.println(routePointService.getOrderRoutePointList(orderId));

        System.out.println("***************** ORDER ************************");
        System.out.println(orderService.findById(orderId));

        System.out.println("******************* CITY ***********************");
        System.out.println(cityService.calcOrderDistance(orderEntity) + "km");
        System.out.println(cityService.calcOrderTime(orderEntity) + "h");



        // Delete order
//        orderEntity = orderService.findById(orderId);

//        orderService.deleteOrder(orderEntity);



        //Driver.

    }



}
