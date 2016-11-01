package com.mkrt4an.servlet;

import com.mkrt4an.dao.CityDao;
import com.mkrt4an.dao.DriverDao;
import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.DriverEntity;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 12.10.2016.
 */
public class UpdateDriverServlet extends HttpServlet {

    @Inject
    DriverDao drd;
    @Inject
    CityDao ctd;
    @Inject
    TruckDao tkd;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");



        Integer id = 0;

        DriverEntity dre;

        String url = request.getServletPath();

        if ("/UpdateDriverServlet".equals(url)) {
            id = Integer.parseInt(request.getParameter("id"));
            dre = drd.findDriverById(id);

            request.setAttribute("driver", dre);
            request.setAttribute("cityAll", ctd.getAllCities());
            request.setAttribute("truckAll", tkd.getAllTrucks());
            request.getRequestDispatcher("/UpdateDriver.jsp").forward(request, response);

        } else if ("/AddDriver".equals(url)) {
            request.setAttribute("truckAll", tkd.getAllTrucks());
            request.setAttribute("cityAll", ctd.getAllCities());
            request.getRequestDispatcher("/AddDriver.jsp").forward(request, response);

        } else if ("/UpdateDriverServletConfirmed".equals(url)) {
            id = Integer.parseInt(request.getParameter("id"));
            dre = drd.findDriverById(id);

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            Integer workedHours = Integer.parseInt(request.getParameter("workedHours"));
            Integer status = Integer.parseInt(request.getParameter("status"));
            Integer cityId = Integer.parseInt(request.getParameter("city"));
//            Integer currentTruckId = Integer.parseInt(request.getParameter("currentTruck"));

            dre.setFirstName(firstName);
            dre.setLastName(lastName);
            dre.setWorkedHours(workedHours);
            dre.setStatus(status);
            dre.setCurrentCity(ctd.findCityById(cityId));
//            dre.setCurrentTruck(tkd.findTruckById(currentTruckId));
            drd.updateDriver(dre);

            request.getRequestDispatcher("/GetAllDriversServlet").forward(request, response);
        }
    }
}
