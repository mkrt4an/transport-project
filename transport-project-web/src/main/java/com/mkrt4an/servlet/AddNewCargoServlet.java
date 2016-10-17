package com.mkrt4an.servlet;

/**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.service.CargoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewCargoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String status = request.getParameter("status");

        new CargoService().addNew(name, weight, status);

        request.getRequestDispatcher("/GetAllCargoServlet").forward(request, response);
    }
}