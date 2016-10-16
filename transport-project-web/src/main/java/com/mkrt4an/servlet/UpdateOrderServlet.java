package com.mkrt4an.servlet;

import com.mkrt4an.dao.DriverDao;
import com.mkrt4an.dao.OrderDao;
import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.OrderEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 12.10.2016.
 */
public class UpdateOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        OrderDao ord = new OrderDao(getEntityManager());
        TruckDao tkd = new TruckDao(getEntityManager());
        DriverDao drd = new DriverDao(getEntityManager());

        OrderEntity ore;

        String url = request.getServletPath();

        if ("/UpdateOrderServlet".equals(url)) {
            ore = ord.findOrderById(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("order", ore);
            request.setAttribute("truckAll", tkd.getAllTrucks());

            request.getRequestDispatcher("/UpdateOrder.jsp").forward(request, response);

        } else if ("/AddOrder".equals(url)) {
            request.setAttribute("truckAll", tkd.getAllTrucks());
            request.setAttribute("driverAll", drd.getAllDrivers());
            request.getRequestDispatcher("/AddOrder.jsp").forward(request, response);

        } else if ("/UpdateOrderServletConfirmed".equals(url)) {
            ore = ord.findOrderById(Integer.parseInt(request.getParameter("id")));

            Integer uid = Integer.parseInt(request.getParameter("uid"));
            Integer status = Integer.parseInt(request.getParameter("status"));
            Integer currentTruckId = Integer.parseInt(request.getParameter("currentTruck"));
//            Integer routePointList = Integer.parseInt(request.getParameter("routePointList"));
//            Integer driverList =  Integer.parseInt(request.getParameter("driverList"));

            ore.setUid(uid);
            ore.setStatus(status);
            ore.setCurrentTruck(tkd.findTruckById(currentTruckId));
//            ore.setRoutePointList(status);
//            ore.setDriverList(ctd.findCityById(cityId));

            ord.updateOrder(ore);

            request.getRequestDispatcher("/GetAllOrdersServlet").forward(request, response);
        }
    }
}
