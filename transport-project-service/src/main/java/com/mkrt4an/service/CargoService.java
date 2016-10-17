package com.mkrt4an.service;

import com.mkrt4an.dao.CargoDao;
import com.mkrt4an.entity.CargoEntity;

import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 02.10.2016.
 */

public class CargoService {

    //Add new
    public void addNew(String name, String weight, String status) {
        CargoDao cgd = new CargoDao(getEntityManager());
        CargoEntity cge = new CargoEntity(name, Integer.parseInt(weight) ,Integer.parseInt(status));
        cgd.createCargo(cge);
    }


    //Find all
    public List<CargoEntity> findAll() {
        CargoDao cgd = new CargoDao(getEntityManager());
        return cgd.getAllCargo();

    }
}
