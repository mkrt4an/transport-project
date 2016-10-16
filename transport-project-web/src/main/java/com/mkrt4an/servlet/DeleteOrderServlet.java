package com.mkrt4an.servlet;

import com.mkrt4an.dao.OrderDao;
import com.mkrt4an.entity.OrderEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 12.10.2016.
 */
public class DeleteOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        OrderDao ord = new OrderDao(getEntityManager());

        Integer id = Integer.parseInt(request.getParameter("id"));

        ord.deleteOrder(ord.findOrderById(id));

        List<OrderEntity> orl = ord.getAllOrders();

        request.setAttribute("list", orl);

        request.getRequestDispatcher("/GetAllOrders.jsp").forward(request, response);
    }
}


