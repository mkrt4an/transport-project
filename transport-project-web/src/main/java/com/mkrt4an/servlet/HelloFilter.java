package com.mkrt4an.servlet;

// Import required java libraries
// Import required java libraries
/**
 * Created by 123 on 03.10.2016.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.annotation.WebFilter;

    public class HelloFilter implements Filter {

        public void init(FilterConfig fConfig) throws ServletException {

        }

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;

            PrintWriter out = res.getWriter();

            String uri = req.getRequestURI();

            if (uri.contains("admin"))
                chain.doFilter(request, response);

            else{
                out.print("username or password error!");
                RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                rd.include(req, res);
            }
        }

        public void destroy() {
            //close any resources here
        }

}




