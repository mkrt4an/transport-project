package com.mkrt4an.servlet;

/**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.service.DriverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetAllDriversServlet extends HttpServlet {

    static final Logger logger = LogManager.getLogger(GetAllDriversServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");;

        request.setAttribute("list", new DriverService().findAllDrivers());

        request.getRequestDispatcher("/GetAllDrivers.jsp").forward(request, response);
    }
}