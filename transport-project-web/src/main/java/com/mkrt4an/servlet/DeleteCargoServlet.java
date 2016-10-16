package com.mkrt4an.servlet;

import com.mkrt4an.dao.CargoDao;
import com.mkrt4an.entity.CargoEntity;

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
public class DeleteCargoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        CargoDao cgd = new CargoDao(getEntityManager());

        Integer id = Integer.parseInt(request.getParameter("id"));

        cgd.deleteCargo(cgd.findCargoById(id));

        List<CargoEntity> cgl = cgd.getAllCargo();

        request.setAttribute("list", cgl);

        request.getRequestDispatcher("/GetAllCargo.jsp").forward(request, response);
    }
}
