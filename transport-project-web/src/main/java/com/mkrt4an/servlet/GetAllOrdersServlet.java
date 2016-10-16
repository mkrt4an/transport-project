package com.mkrt4an.servlet; /**
 * Created by 123 on 04.10.2016.
 */

import com.mkrt4an.dao.OrderDao;
import com.mkrt4an.entity.OrderEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.mkrt4an.utils.EntityManagerHelper.getEntityManager;

public class GetAllOrdersServlet extends HttpServlet {

    static final Logger logger = LogManager.getLogger(GetAllDriversServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        OrderDao ord = new OrderDao(getEntityManager());

        List<OrderEntity> orl = ord.getAllOrders();

        request.setAttribute("list", orl);

        request.getRequestDispatcher("/GetAllOrders.jsp").forward(request, response);
    }
}