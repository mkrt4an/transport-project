package com.mkrt4an.service;

import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.TruckEntity;

import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 02.10.2016.
 */

public class TruckService {

    //Find by id
    public TruckEntity findById(String id) {
        TruckDao truckDao = new TruckDao(getEntityManager());
        return truckDao.findTruckById(Integer.parseInt(id));
    }


    // Find all trucks
    public List<TruckEntity> findAllTrucks (){
        TruckDao truckDao = new TruckDao(getEntityManager());
        return truckDao.getAllTrucks();
    }

    public void deleteById(Integer Id) {
        TruckDao truckDao = new TruckDao(getEntityManager());
//        TruckEntity truckEntity = truckDao.findTruckById(Id);
        truckDao.deleteTruck(truckDao.findTruckById(Id));
    }

    public void deleteById(String Id) {
        TruckDao truckDao = new TruckDao(getEntityManager());
//        TruckEntity truckEntity = ;
        truckDao.deleteTruck(truckDao.findTruckById(Integer.parseInt(Id)));
    }


}
