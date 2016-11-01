package com.mkrt4an.servlet;

import com.mkrt4an.dao.CityDao;
import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.TruckEntity;

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
public class UpdateTruckServlet extends HttpServlet {

    @Inject
    TruckDao tkd;
    @Inject
    CityDao ctd;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        Integer id = 0;

        TruckEntity tke;

        String url = request.getServletPath();

        if ("/UpdateTruckServlet".equals(url)){
            id = Integer.parseInt(request.getParameter("id"));
            tke = tkd.findTruckById(id);

            request.setAttribute("truck", tke);
            request.setAttribute("cityAll", ctd.getAllCities());
            request.getRequestDispatcher("/UpdateTruck.jsp").forward(request, response);

        } else if ("/AddTruck".equals(url)) {
            request.setAttribute("cityAll", ctd.getAllCities());
            request.getRequestDispatcher("/AddTruck.jsp").forward(request, response);

        } else if ("/UpdateTruckServletConfirmed".equals(url)) {
            id = Integer.parseInt(request.getParameter("id"));
            tke = tkd.findTruckById(id);

            Integer dutySize = Integer.parseInt(request.getParameter("dutySize"));
            Integer capasity = Integer.parseInt(request.getParameter("capasity"));
            String regNumber = request.getParameter("regNumber");
            Integer status = Integer.parseInt(request.getParameter("status"));
            Integer cityId =  Integer.parseInt(request.getParameter("city"));

            tke.setDutySize(dutySize);
            tke.setCapasity(capasity);
            tke.setRegNumber(regNumber);
            tke.setStatus(status);
            tke.setCurrentCity(ctd.findCityById(cityId));

            tkd.updateTruck(tke);

            request.getRequestDispatcher("/GetAllTrucksServlet").forward(request, response);
        }
    }
}
