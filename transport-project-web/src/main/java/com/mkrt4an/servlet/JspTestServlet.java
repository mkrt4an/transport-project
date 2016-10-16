package com.mkrt4an.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 123 on 12.10.2016.
         */


public class JspTestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        List<String> list = new ArrayList<String>();
//        String list = "1234";
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");

//        PrintWriter out = response.getWriter();
//        out.println(list);

        request.setAttribute("list", list);

        request.getRequestDispatcher("/jspTestPage.jsp").forward(request,response);
    }

}