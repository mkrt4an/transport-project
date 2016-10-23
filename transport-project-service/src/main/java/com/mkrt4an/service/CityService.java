package com.mkrt4an.service;

import com.mkrt4an.dao.CityDao;
import com.mkrt4an.entity.CityEntity;

import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 02.10.2016.
 */


public class CityService {


    //Find all orders
    public List<CityEntity> findAll() {
        CityDao cityDao = new CityDao(getEntityManager());
        return cityDao.getAllCities();
    }

    // Find by id
    public CityEntity findById(String id) {
        CityDao cityDao = new CityDao(getEntityManager());
        return cityDao.findCityById(Integer.parseInt(id));
    }

    // Find by id
    public CityEntity findById(Integer id) {
        CityDao cityDao = new CityDao(getEntityManager());
        return cityDao.findCityById(id);
    }


}