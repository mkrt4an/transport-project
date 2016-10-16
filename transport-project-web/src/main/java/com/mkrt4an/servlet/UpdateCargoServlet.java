package com.mkrt4an.servlet;

import com.mkrt4an.dao.CargoDao;
import com.mkrt4an.entity.CargoEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

/**
 * Created by 123 on 12.10.2016.
 */
public class UpdateCargoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        CargoDao cgd = new CargoDao(getEntityManager());

        Integer id = 0;

        CargoEntity cge;

        String url = request.getServletPath();

        if ("/UpdateCargoServlet".equals(url)){
            id = Integer.parseInt(request.getParameter("id"));

            request.setAttribute("cargo", cgd.findCargoById(id));

            request.getRequestDispatcher("/UpdateCargo.jsp").forward(request, response);

        } else if ("/AddCargo".equals(url)) {
//            request.setAttribute("cityAll", ctd.getAllCities());
            request.getRequestDispatcher("/AddCargo.jsp").forward(request, response);

        } else if ("/UpdateCargoServletConfirmed".equals(url)) {

            id = Integer.parseInt(request.getParameter("id"));

            cge =  cgd.findCargoById(id);

            String name = request.getParameter("name");
            Integer weight = Integer.parseInt(request.getParameter("weight"));
            Integer status = Integer.parseInt(request.getParameter("status"));

            cge.setName(name);
            cge.setWeight(weight);
            cge.setStatus(status);

            cgd.updateCargo(cge);

            request.getRequestDispatcher("/GetAllCargoServlet").forward(request, response);
        }
    }
}
