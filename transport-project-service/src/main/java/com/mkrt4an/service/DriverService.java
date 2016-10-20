package com.mkrt4an.service;

import com.mkrt4an.dao.DriverDao;
import com.mkrt4an.entity.DriverEntity;

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


    // Find all drivers
    public List<DriverEntity> findAllDrivers() {
        return null;
    }


    //Get driver info
//    public String getDriverInfo(DriverEntity de) {
//        de.getId();
//        de.getCurrentTruck();

//        getCurrentOrder();

//        getCurrentOrder().getRoutePointList

//        return null;
//    }

    // Get list of avaible drivers for order
    public List<DriverEntity> getAvaibleDriverForOrder() {
        return null;
    }
}
