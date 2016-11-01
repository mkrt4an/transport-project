package com.mkrt4an.service;

import com.mkrt4an.dao.CargoDao;
import com.mkrt4an.dao.RoutePointDao;
import com.mkrt4an.entity.CargoEntity;

import javax.inject.Inject;
import java.util.List;

//import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 02.10.2016.
 */

public class CargoService {

    @Inject
    CargoDao cargoDao;

    public CargoService() {}

    //Add new
    public Integer addNew(String name, String weight, String status) {

        CargoEntity cargoEntity = new CargoEntity(name, Integer.parseInt(weight), Integer.parseInt(status));
        cargoDao.createCargo(cargoEntity);
        return cargoEntity.getId();
    }

    //Add new
    public Integer addNew(String name, Integer weight, Integer status) {
//        CargoDao cargoDao = new CargoDao(getEntityManager());
        CargoEntity cargoEntity = new CargoEntity(name, weight, status);
        cargoDao.createCargo(cargoEntity);
        return cargoEntity.getId();
    }

//    //Add new
//    public Integer addNew(String name, Integer weight, Integer status,
//                          Integer loadingRoutePoint,
//                          Integer deliveryRoutePoint) {
//
////        CargoDao cargoDao = new CargoDao(getEntityManager());
//        /////////////////////////////////////
////        RoutePointDao routePointDao = new RoutePoint//Dao(getEntityManager());
//
//        CargoEntity cargoEntity = new CargoEntity(name, weight, status,
//                routePointDao.findRoutePointById(loadingRoutePoint),
//                routePointDao.findRoutePointById(deliveryRoutePoint)
//        );
//
//        cargoDao.createCargo(cargoEntity);
//        return cargoEntity.getId();
//    }

    //Find by id
    public CargoEntity findById(String id) {
//        CargoDao cargoDao = new CargoDao(getEntityManager());
        return  cargoDao.findCargoById(Integer.parseInt(id));
    }

    //Find by id
    public CargoEntity findById(Integer id) {
//        CargoDao cargoDao = new CargoDao(getEntityManager());
        return  cargoDao.findCargoById(id);
    }

    //Find all
    public List<CargoEntity> findAll() {
//        CargoDao cargoDao = new CargoDao(getEntityManager());
        return cargoDao.getAllCargo();
    }

    //Delete by id
    public void deleteById(String id){
//        CargoDao cargoDao = new CargoDao(getEntityManager());
        cargoDao.deleteCargo(cargoDao.findCargoById(Integer.parseInt(id)));
    }

    //Update
    public void update(String id, String name, String weight, String status){

//        CargoDao cargoDao = new CargoDao(getEntityManager());
        CargoEntity cargoEntity;
        cargoEntity = cargoDao.findCargoById(Integer.parseInt(id));

        cargoEntity.setName(name);
        cargoEntity.setWeight(Integer.parseInt(weight));
        cargoEntity.setStatus(Integer.parseInt(status));

        cargoDao.updateCargo(cargoEntity);
    }

}
