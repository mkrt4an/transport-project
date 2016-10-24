package com.mkrt4an.service;

import com.mkrt4an.dao.CityDao;
import com.mkrt4an.entity.CityEntity;
import com.mkrt4an.entity.OrderEntity;

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

    //Calc distance between two cities
    public Double calcDistance(CityEntity cityA, CityEntity cityB) {
        return Math.pow((cityA.getX() - cityB.getX()), 2) + Math.pow((cityA.getY() - cityB.getY()), 2);
    }

    public Integer calcOrderDistance(OrderEntity orderEntity) {
        Double distance = 0d;

        int i = 0;
        while(!orderEntity.getRoutePointList().isEmpty()) {
            distance =+ calcDistance(orderEntity.getRoutePointList().get(i).getCity(), orderEntity.getRoutePointList().get(i+1).getCity());
            i++;
        }

        return distance.intValue();
    }

    //Calc time of all order
    public Integer calcOrderTime(OrderEntity orderEntity) {
        final Integer AVERAGE_SPEED = 60;
        return calcOrderDistance(orderEntity) / AVERAGE_SPEED;
    }
}