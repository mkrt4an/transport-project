package com.mkrt4an.servlet;

import com.mkrt4an.service.CargoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 123 on 12.10.2016.
 */
public class UpdateCargoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String id = "";

        CargoService cargoService = new CargoService();

        String url = request.getServletPath();

        if ("/UpdateCargoServlet".equals(url)){

            id = request.getParameter("id");
            request.setAttribute("cargo", cargoService.findById(id));
            request.getRequestDispatcher("/UpdateCargo.jsp").forward(request, response);

        } else if ("/AddCargo".equals(url)) {

            request.getRequestDispatcher("/AddCargo.jsp").forward(request, response);

        } else if ("/UpdateCargoServletConfirmed".equals(url)) {

            id = request.getParameter("id");

            String name = request.getParameter("name");
            String weight = request.getParameter("weight");
            String status = request.getParameter("status");

            cargoService.update(id, name, weight, status);

            request.getRequestDispatcher("/GetAllCargoServlet").forward(request, response);
        }
    }
}
