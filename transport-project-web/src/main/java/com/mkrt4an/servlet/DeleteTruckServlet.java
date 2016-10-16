package com.mkrt4an.servlet;

import com.mkrt4an.dao.TruckDao;
import com.mkrt4an.entity.TruckEntity;

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
public class DeleteTruckServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        TruckDao tkd = new TruckDao(getEntityManager());

        Integer id = Integer.parseInt(request.getParameter("id"));

        tkd.deleteTruck(tkd.findTruckById(id));

        List<TruckEntity> tkl = tkd.getAllTrucks();

        request.setAttribute("list", tkl);

        request.getRequestDispatcher("/GetAllTrucks.jsp").forward(request, response);
    }
}