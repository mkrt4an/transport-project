package com.mkrt4an.servlet;

/**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.dao.CityDao;
import com.mkrt4an.dao.DriverDao;
import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.DriverEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

public class AddNewDriverServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Integer workedHours = Integer.parseInt(request.getParameter("workedHours"));
        Integer status = Integer.parseInt(request.getParameter("status"));
        Integer cityId =  Integer.parseInt(request.getParameter("city"));
        Integer currentTruckId  =  Integer.parseInt(request.getParameter("currentTruck"));

        DriverDao drd = new DriverDao(getEntityManager());
        CityDao ctd = new CityDao(getEntityManager());
        TruckDao tkd = new TruckDao(getEntityManager());

        DriverEntity dre;
        dre = new DriverEntity(firstName, lastName, workedHours, status, tkd.findTruckById(currentTruckId), ctd.findCityById(cityId));

        drd.createDriver(dre);

        List<DriverEntity> drl = drd.getAllDrivers();

        request.setAttribute("list", drl);

        request.getRequestDispatcher("/GetAllDrivers.jsp").forward(request, response);
    }
}