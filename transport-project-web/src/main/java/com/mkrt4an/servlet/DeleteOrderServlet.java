package com.mkrt4an.servlet;

import com.mkrt4an.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 123 on 12.10.2016.
 */
public class DeleteOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        new OrderService().deleteById(request.getParameter("id"));

        request.getRequestDispatcher("/GetAllOrdersServlet").forward(request, response);
    }
}


