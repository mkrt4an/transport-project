package com.mkrt4an.servlet;

/**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.service.TruckService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;

public class GetAllTrucksServlet extends HttpServlet {

    @Inject
    TruckService truckService;

    static final Logger logger = LogManager.getLogger(GetAllTrucksServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        request.setAttribute("list", truckService.findAllTrucks());

        request.getRequestDispatcher("/GetAllTrucks.jsp").forward(request, response);
    }
}