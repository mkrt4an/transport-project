package com.mkrt4an.service;

import com.mkrt4an.entity.DriverEntity;

import java.util.List;

/**
 * Created by 123 on 02.10.2016.
 */

public class DriverService {

    // Find all drivers
    public List<DriverEntity> findAllDrivers (){
        return null;
    }


    //Get driver info
    public String getDriverInfo(DriverEntity de) {
        de.getId();
        de.getCurrentTruck();

//        getCurrentOrder();

//        getCurrentOrder().getRoutePointList

        return null;
    }

    // Get list of avaible drivers for order
    public List<DriverEntity> getAvaibleDriverForOrder() {
        return null;
    }
}
