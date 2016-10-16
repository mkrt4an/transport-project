package com.mkrt4an.servlet;

/**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.dao.CityDao;
import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.TruckEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

public class AddNewTruckServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        Integer dutySize = Integer.parseInt(request.getParameter("dutySize"));
        Integer capasity = Integer.parseInt(request.getParameter("capasity"));
        String regNumber = request.getParameter("regNumber");
        Integer status = Integer.parseInt(request.getParameter("status"));
        Integer cityId =  Integer.parseInt(request.getParameter("city"));

        TruckDao tkd = new TruckDao(getEntityManager());
        CityDao ctd = new CityDao(getEntityManager());

        TruckEntity tke;
        tke = new TruckEntity(dutySize, capasity, status, regNumber, ctd.findCityById(cityId));

        tkd.createTruck(tke);

        List<TruckEntity> tkl = tkd.getAllTrucks();

        request.setAttribute("list", tkl);

        request.getRequestDispatcher("/GetAllTrucks.jsp").forward(request, response);
    }
}