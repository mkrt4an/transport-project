package com.mkrt4an.servlet;

/**
 * Created by 123 on 03.10.2016.
 */

// Import required java libraries
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Extend HttpServlet class
public class HelloServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World from HelloServlet";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        String s = "dfgdfgdg";
        out.println("<h1> This time you won " + request.getAttribute(s) + "! </h1>");
    }

    public void destroy()
    {
        // do nothing.
    }
}