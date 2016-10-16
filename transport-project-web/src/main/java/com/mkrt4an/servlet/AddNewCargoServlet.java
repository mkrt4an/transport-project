package com.mkrt4an.servlet;

/**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.dao.CargoDao;
import com.mkrt4an.entity.CargoEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

public class AddNewCargoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        Integer weight = Integer.parseInt(request.getParameter("weight"));
        Integer status = Integer.parseInt(request.getParameter("status"));

        CargoDao cgd = new CargoDao(getEntityManager());

        CargoEntity cge = new CargoEntity(name, weight, status);

        cgd.createCargo(cge);

        List<CargoEntity> cgl = cgd.getAllCargo();

        request.setAttribute("list", cgl);

        request.getRequestDispatcher("/GetAllCargo.jsp").forward(request, response);
    }
}