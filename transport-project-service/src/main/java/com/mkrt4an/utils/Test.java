package com.mkrt4an.utils;


import com.mkrt4an.service.*;

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
//        RoutePointDao routePoint = new RoutePointDao(getEntityManager());
//        UserDao user = new UserDao(getEntityManager());
//        PassportDao passport = new PassportDao(getEntityManager());

        // Services
        RoutePointService routePointService = new RoutePointService();
        CargoService cargoService = new CargoService();
        CityService cityService = new CityService();
        OrderService orderService = new OrderService();


        // Try
//        List<CargoEntity> cargoToLoad = new ArrayList<CargoEntity>();
//        cargoToLoad.add(cargoService.findById(1));
//        cargoToLoad.add(cargoService.findById(2));
//        cargoToLoad.add(cargoService.findById(3));
//
//        List<CargoEntity> cargoToDeliver = new ArrayList<CargoEntity>();
//        cargoToDeliver.add(cargoService.findById(4));
//        cargoToDeliver.add(cargoService.findById(5));
//        cargoToDeliver.add(cargoService.findById(6));
//
//        // Add rp
//        Integer addRoutePoint = routePointService.AddRoutePoint(
//                cargoToLoad,
//                cargoToDeliver,
//                1,
//                cityService.findById(1),
//                orderService.findById(1)
//        );

//        new OrderService().deleteById(130);

//        System.out.println(orderService.findAll());

        System.out.println(new DriverService().getDriverInfo(1));

    }
}
