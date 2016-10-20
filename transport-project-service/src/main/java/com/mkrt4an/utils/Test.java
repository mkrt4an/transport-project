package com.mkrt4an.utils;


import com.mkrt4an.dao.*;
import com.mkrt4an.entity.OrderEntity;
import com.mkrt4an.entity.RoutePointEntity;
import com.mkrt4an.service.OrderService;

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

        CargoDao cargo = new CargoDao(getEntityManager());
        TruckDao truck = new TruckDao(getEntityManager());
        DriverDao driver = new DriverDao(getEntityManager());
        OrderDao order = new OrderDao(getEntityManager());
        CityDao city = new CityDao(getEntityManager());
        RoutePointDao routePoint = new RoutePointDao(getEntityManager());
        UserDao user = new UserDao(getEntityManager());
        PassportDao passport = new PassportDao(getEntityManager());

//        System.out.println(truck.getAllTrucks());
//        System.out.println(driver.getAllDrivers());
//        System.out.println(order.getAllOrders());
//        System.out.println(city.getAllCities());
//        System.out.println(routePoint.getAllRoutePoints());

//        CargoEntity ce1 = new CargoEntity(11, "bb", 111, 1);
//        CargoEntity ce2 = new CargoEntity(10, "bb", 222, 1);


//        UserEntity==================================
//        UserEntity us1;
//          us1= new UserEntity(7, "mmm");

//        us1 = user.findUserById(7);
//        us1.setName("mmm_update_2");

//        us1 = user.findUserById(5);
//        user.deleteUser(us1);

//        us1 = new UserEntity("zzz");
//        user.createUser(us1);
//
//        us1 = new UserEntity();
//        user.createUser(us1);
//        user.updateUser(us1);
//        user.deleteUser(user.findUserById(1));

//        System.out.println(user.getAll());

//        PassportEntity =============================
//        PassportEntity pte;

//        passport.delete(passport.findById(9));

//        System.out.println(passport.getAll());


//        CargoEntity================================
//        CargoEntity cge;

//        cge = new CargoEntity();
//        cargo.createCargo(cge);

//        cge = new CargoEntity("tools", 123, 3);
//        cargo.createCargo(cge);

//        cge = cargo.findCargoById(12);
//        cge.setName("rtrtrt");
//        cge.setWeight(321);
//        cge.setStatus(3);


//        cargo.updateCargo(cge);

//        cargo.deleteCargo(cge);

//        System.out.println(cargo.getAllCargo());

//        cargo.deleteCargo(cargo.findCargoById(1));

//        System.out.println(cargo.getAllCargo());


//         CityEntity ==============================
//        CityEntity cte;

//        city.findCityById(2);
//        city.getAllCities();

//        cte = new CityEntity("Praha", 555, 666);
//        city.createCity(cte);

//        city.deleteCity(city.findCityById(2));

//        System.out.println(city.getAllCities());


//         Driver Entity =============================
//        DriverEntity dre;

//        dre = driver.findDriverById(26);

//        dre.setFirstName("www_update");
//        dre.setFirstName("Ivan-update");

//        driver.updateDriver(dre);

//        driver.deleteDriver(dre);

//        System.out.println(driver.getAllDrivers());


//        OrderEntity ===============================
//        OrderEntity ore;

//        ore = new OrderEntity(222, 2, null, null, null);

//        ore = order.findOrderById(1);

//        ore.setCurrentTruck(truck.findTruckById(1));

//        order.createOrder(ore);

//        System.out.println(order.getAllOrders());
//        order.updateOrder(ore);
//        order.deleteOrder(ore);

//        System.out.println(order.getAllOrders());
//        System.out.println(order.findOrderById(1));


//        RoutePoint ================================
//        RoutePointEntity rpe;

//        rpe = new RoutePointEntity(2, city.findCityById(1), cargo.findCargoById(1), order.findOrderById(1));

//        routePoint.createRoutePoint(rpe);

//        routePoint.deleteRoutePoint(routePoint.findRoutePointById(7));

//        System.out.println(routePoint.getAllRoutePoints());


//        TruckEntity ===============================
//        TruckEntity tke;

//        tke = new TruckEntity(2, 122, 2, "BELAZ123", city.findCityById(3));

//        truck.createTruck(tke);

//        truck.deleteTruck(truck.findTruckById(4));

//        System.out.println(truck.getAllTrucks());
//        System.out.println(truck.findTruckById(1));


//========================== ORDER================================

        //------------route points list
        OrderService orderService = new OrderService();

//        Integer i;
//        i = orderService.addOrder(222, cargo.findCargoById(6), city.findCityById(3), city.findCityById(4));

//        System.out.println(orderService.findById(String.valueOf(i)));

//        System.out.println(orderService.getSuitableTruckList(order.findOrderById(18)));



        //===============================================================
        List<RoutePointEntity> routePointEntityList = new ArrayList<>();
        routePointEntityList.add(routePoint.findRoutePointById(1));
        routePointEntityList.add(routePoint.findRoutePointById(2));
//        routePointEntityList.add(routePoint.findRoutePointById(3));
//

        OrderEntity orderDraft = new OrderEntity(54321, 0, routePointEntityList);
        orderDraft.assignRoutePointList(routePointEntityList);

        orderDraft.setCurrentTruck(orderService.getSuitableTruck(orderDraft));
        if (orderService.getSuitableTruck(orderDraft) != null) {
            orderDraft.assignCurrentTruck(orderService.getSuitableTruck(orderDraft));
        }

        orderDraft.setDriverList(orderService.getSuitableDriverList(orderDraft));
        orderDraft.assignDriverList(orderService.getSuitableDriverList(orderDraft));


//        OrderEntity orderEntity = new OrderEntity(12345, 0, routePointEntityList,
//                orderService.getSuitableDriverList(orderDraft),
//                orderService.getSuitableTruck(orderDraft));
//========================================================
//

        order.updateOrder(orderDraft);

//        orderService.deleteOrder(order.findOrderById(37));

        System.out.println(orderDraft);


//=============================================================
//        PassportEntity passportEntity = passport.findById(1);

//        UserEntity userEntity = user.findById(1);

//        userEntity.setPassport(passportEntity);
//        passportEntity.assignUser(userEntity);

//        passport.update(passportEntity);

//        passportEntity.setUser(userEntity);

//        System.out.println(passportEntity.getUser().getPassport());
//        System.out.println(userEntity.getPassport());


    }
}
