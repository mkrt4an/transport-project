package com.mkrt4an.servlet;

import com.mkrt4an.service.TruckService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 123 on 12.10.2016.
 */
public class DeleteTruckServlet extends HttpServlet {

    @Inject
    TruckService truckService;



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        truckService.deleteById(request.getParameter("id"));

        request.getRequestDispatcher("/GetAllTrucksServlet").forward(request, response);
    }
}