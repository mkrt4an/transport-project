package com.mkrt4an.servlet;

import com.mkrt4an.dao.CargoDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out=response.getWriter();

//        request.getRequestDispatcher("link.html").include(request, response);

//        Cookie ck=new Cookie("name","");
//        ck.setMaxAge(0);
//        response.addCookie(ck);

        CargoDao cargo =   new CargoDao(getEntityManager());

//        CargoDao cgd;

        out.print(cargo.findCargoById(2));
    }
}