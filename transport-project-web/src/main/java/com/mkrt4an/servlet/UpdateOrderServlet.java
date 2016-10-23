package com.mkrt4an.servlet;

import com.mkrt4an.dao.CargoDao;
import com.mkrt4an.dao.DriverDao;
import com.mkrt4an.dao.OrderDao;
import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.OrderEntity;
import com.mkrt4an.service.*;

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

//            OrderService orderService = new OrderService();

            request.setAttribute("truckAll", tkd.getAllTrucks());
            request.setAttribute("driverAll", drd.getAllDrivers());
            request.setAttribute("cargoAll", new CargoService().findAll());
            request.setAttribute("cityAll", new CityService().findAll());
            request.setAttribute("orderId", new OrderService().addOrder());

//            request.getRequestDispatcher("/AddOrderStepOne.jsp").forward(request, response);
            request.getRequestDispatcher("/RP.jsp").forward(request, response);

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

        } else if ("/test".equals(url)) {

            Integer integer = Integer.parseInt(request.getParameter("id"));
            CargoDao cargoDao = new CargoDao(getEntityManager());
            String name = cargoDao.findCargoById(integer).toString();
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(name);

        } else if ("/new-cargo".equals(url)) {

//            Integer id = Integer.parseInt(request.getParameter("id"));
//            Integer uid = Integer.parseInt(request.getParameter("uid"));

            Integer cityId = Integer.parseInt(request.getParameter("cityId"));
            Integer routePointId = Integer.parseInt(request.getParameter("routePointId"));
            Integer orderId = Integer.parseInt(request.getParameter("orderId"));


            String cargoName = request.getParameter("cargoName");
            Integer cargoWeight = Integer.parseInt(request.getParameter("cargoWeight"));

            RoutePointService routePointService = new RoutePointService();

            if (routePointId == null) {
                routePointId = routePointService.AddRoutePointBlank(cityId, orderId);
            }

            routePointService.AddCargoToLoadingList(orderId, routePointId, cargoName, cargoWeight);

            request.setAttribute("routePointId", routePointId);
            request.setAttribute("routePoint", routePointService.findById(routePointId));
            request.setAttribute("cargoToLoadList", routePointService.findById(routePointId).getCargoToLoadList());
            request.setAttribute("cargoToDeliverList", routePointService.findById(routePointId).getCargoToDeliverList());
            request.setAttribute("cityAll", new CityService().findAll());
            request.setAttribute("orderId", new OrderService().findById(orderId).getId());
            request.setAttribute("cityId", new CityService().findById(cityId).getId());

            request.getRequestDispatcher("/RP.jsp").forward(request, response);


        } else if ("/route-point".equals(url)) {

            RoutePointService routePointService = new RoutePointService();

            Integer cityId = Integer.parseInt(request.getParameter("cityId"));
            Integer orderId = Integer.parseInt(request.getParameter("orderId"));

            Integer routePointId = 0;

            if ("".equals(request.getParameter("routePointId"))) {
                routePointId = routePointService.AddRoutePointBlank(cityId, orderId);
            } else {
                routePointId = routePointService.AddRoutePointBlank(cityId, orderId);
            }

            request.setAttribute("routePointId", routePointId);
            request.setAttribute("routePoint", routePointService.findById(routePointId));
            request.setAttribute("cargoToLoadList", routePointService.findById(routePointId).getCargoToLoadList());
            request.setAttribute("cargoToDeliverList", routePointService.findById(routePointId).getCargoToDeliverList());
            request.setAttribute("cityAll", new CityService().findAll());
            request.setAttribute("orderId", new OrderService().findById(orderId).getId());
            request.setAttribute("cityId", new CityService().findById(cityId).getId());

            request.getRequestDispatcher("/RP.jsp").forward(request, response);

        } else if ("/ready".equals(url)) {

            RoutePointService routePointService = new RoutePointService();

            Integer cityId = Integer.parseInt(request.getParameter("cityId"));
            Integer orderId = Integer.parseInt(request.getParameter("orderId"));

            Integer routePointId = 0;

            if ("".equals(request.getParameter("routePointId"))) {
                routePointId = routePointService.AddRoutePointBlank(cityId, orderId);
            } else {
                routePointId = routePointService.AddRoutePointBlank(cityId, orderId);
            }

            request.setAttribute("routePointId", routePointId);
            request.setAttribute("routePoint", routePointService.findById(routePointId));
            request.setAttribute("cargoToLoadList", routePointService.findById(routePointId).getCargoToLoadList());
            request.setAttribute("cargoToDeliverList", routePointService.findById(routePointId).getCargoToDeliverList());
            request.setAttribute("cityAll", new CityService().findAll());
            request.setAttribute("cityId", new CityService().findById(cityId).getId());

            request.setAttribute("orderId", orderId);
//            request.setAttribute("truckAll", orderService.getSuitableTruckList(orderEntity));
            request.setAttribute("truckAll", new TruckService().findAllTrucks());

//            request.getRequestDispatcher("/RP.jsp").forward(request, response);
            request.getRequestDispatcher("/AddOrderStepTwo.jsp").forward(request, response);

        } else if ("/new-city".equals(url)) {

            RoutePointService routePointService = new RoutePointService();

            Integer cityId = Integer.parseInt(request.getParameter("cityId"));
            Integer orderId = Integer.parseInt(request.getParameter("orderId"));

            Integer routePointId = 0;
            if ("".equals(request.getParameter("routePointId"))) {
                routePointId = routePointService.AddRoutePointBlank(cityId, orderId);
            } else {
                routePointId = routePointService.AddRoutePointBlank(cityId, orderId);
            }

            request.setAttribute("routePointId", routePointId);
            request.setAttribute("routePoint", routePointService.findById(routePointId));
            request.setAttribute("cargoToLoadList", routePointService.findById(routePointId).getCargoToLoadList());
            request.setAttribute("cargoToDeliverList", routePointService.findById(routePointId).getCargoToDeliverList());
            request.setAttribute("cityAll", new CityService().findAll());
            request.setAttribute("orderId", new OrderService().findById(orderId).getId());
            request.setAttribute("cityId", new CityService().findById(cityId).getId());

            request.getRequestDispatcher("/RP.jsp").forward(request, response);
        }




    }
}
