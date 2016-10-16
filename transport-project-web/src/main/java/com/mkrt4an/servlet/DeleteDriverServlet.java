package com.mkrt4an.servlet;

import com.mkrt4an.dao.DriverDao;
import com.mkrt4an.entity.DriverEntity;

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
public class DeleteDriverServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        DriverDao drd = new DriverDao(getEntityManager());

        Integer id = Integer.parseInt(request.getParameter("id"));

        drd.deleteDriver(drd.findDriverById(id));

        List<DriverEntity> drl = drd.getAllDrivers();

        request.setAttribute("list", drl);

        request.getRequestDispatcher("/GetAllDrivers.jsp").forward(request, response);
    }
}


