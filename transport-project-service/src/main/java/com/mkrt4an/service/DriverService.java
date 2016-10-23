package com.mkrt4an.service;

import com.mkrt4an.dao.DriverDao;
import com.mkrt4an.entity.DriverEntity;
import com.mkrt4an.entity.RoutePointEntity;

import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 02.10.2016.
 */

public class DriverService {

    //Find by id
    public DriverEntity findById(String id) {
        DriverDao driverDao = new DriverDao(getEntityManager());
        return driverDao.findDriverById(Integer.parseInt(id));
    }

    //Delete by id
    public void deleteById(String id){
        DriverDao driverDao = new DriverDao(getEntityManager());
        driverDao.deleteDriver(driverDao.findDriverById(Integer.parseInt(id)));
    }


    // Find all drivers
    public List<DriverEntity> findAllDrivers() {
        return null;
    }


    //Get driver info
    public String getDriverInfo(Integer driverId) {
        DriverDao driverDao = new DriverDao(getEntityManager());

        DriverEntity driverEntity  = driverDao.findDriverById(driverId);

        StringBuffer codriverList = new StringBuffer();

        List<DriverEntity> driverEntityList = driverEntity.getOrder().getDriverList();

        for (DriverEntity entity : driverEntityList) {
            if (entity == driverEntity) {continue;}
            codriverList.append(entity.getId());
            codriverList.append(", ");
        }

        codriverList.deleteCharAt(codriverList.length() - 2);


        StringBuffer routePointList = new StringBuffer();
        for (RoutePointEntity entity : driverEntity.getOrder().getRoutePointList()) {
            routePointList.append(entity.getOrdinal() + " - " + entity.getCity() + ", ");
        }

        routePointList.deleteCharAt(routePointList.length() - 2);

        return "id: " + driverEntity.getId() + "\n" +
                "co-id: " + codriverList + "\n" +
                "Truck regNumber: " + driverEntity.getOrder().getCurrentTruck().getRegNumber() + "\n" +
                "Order number: " + driverEntity.getOrder().getId() + "\n" +
                "RoutePointList: " + routePointList;
    }

    // Get list of avaible drivers for order
    public List<DriverEntity> getAvaibleDriverForOrder() {
        return null;
    }
}
