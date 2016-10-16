package com.mkrt4an.servlet;

/**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.dao.OrderDao;
import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.OrderEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

public class AddNewOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        Integer uid = Integer.parseInt(request.getParameter("uid"));
        Integer status = Integer.parseInt(request.getParameter("status"));
        Integer currentTruckId = Integer.parseInt(request.getParameter("currentTruck"));
//        Integer status = Integer.parseInt(request.getParameter("status"));

        OrderDao ord = new OrderDao(getEntityManager());
        TruckDao tkd = new TruckDao(getEntityManager());

        OrderEntity ore = new OrderEntity(uid, status, tkd.findTruckById(currentTruckId));

        ord.createOrder(ore);

        List<OrderEntity> orl = ord.getAllOrders();

        request.setAttribute("list", orl);

        request.getRequestDispatcher("/GetAllOrders.jsp").forward(request, response);
    }
}