package com.mkrt4an.servlet;

/**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.entity.DriverEntity;
import com.mkrt4an.entity.OrderEntity;
import com.mkrt4an.service.DriverService;
import com.mkrt4an.service.OrderService;
import com.mkrt4an.service.TruckService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddNewOrderServletStepOne extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String url = request.getServletPath();
//        Integer orderId = 0;

        OrderService orderService = new OrderService();
        TruckService truckService = new TruckService();
        DriverService driverService = new DriverService();

//        OrderEntity orderEntity = null;

        if ("/AddNewOrderServletStepOne".equals(url)) {

            Integer uid = Integer.parseInt(request.getParameter("uid"));
            Integer cargoId = Integer.parseInt(request.getParameter("cargoId"));
            Integer fromCityId = Integer.parseInt(request.getParameter("fromCityId"));
            Integer toCityId = Integer.parseInt(request.getParameter("toCityId"));
            Integer orderId = Integer.parseInt(request.getParameter("orderId"));

//            Integer orderId = orderService.addOrder(uid, cargoId, fromCityId, toCityId);

            OrderEntity orderEntity = orderService.findById(String.valueOf(orderId));

            request.setAttribute("orderId", orderId);
//            request.setAttribute("truckAll", orderService.getSuitableTruckList(orderEntity));
            request.setAttribute("truckAll", new TruckService().findAllTrucks());

            request.getRequestDispatcher("/AddOrderStepTwo.jsp").forward(request, response);

        } else if ("/AddNewOrderServletStepTwo".equals(url)) {

            Integer orderId = Integer.parseInt(request.getParameter("orderId"));
            String truckId = request.getParameter("truckId");

            OrderEntity orderEntity = orderService.findById(String.valueOf(orderId));

            orderEntity.setCurrentTruck(truckService.findById(truckId));
            orderService.update(orderEntity);

            request.setAttribute("orderId", orderId);
            request.setAttribute("truckId", truckId);
            request.setAttribute("currentTruckDutySize", truckService.findById(String.valueOf(truckId)).getDutySize());
            request.setAttribute("driverAll", orderService.getSuitableDriverList(orderEntity));

            request.getRequestDispatcher("/AddOrderStepThree.jsp").forward(request, response);

        } else if ("/AddNewOrderServletStepThree".equals(url)) {

            Integer orderId = Integer.parseInt(request.getParameter("orderId"));
            String truckId = request.getParameter("truckId");

            String[] driverIdList = request.getParameterValues("driverId");

            List<DriverEntity> driverEntityList = new ArrayList<>();
            for (String s : driverIdList) {
                driverEntityList.add(driverService.findById(s));
            }

            OrderEntity orderEntity = orderService.findById(String.valueOf(orderId));
            orderEntity.assignDriverList(driverEntityList);
//            orderEntity.assignCurrentTruck(truckService.findById(truckId));

            orderService.update(orderEntity);

            request.getRequestDispatcher("/GetAllOrdersServlet").forward(request, response);
        }
    }
}