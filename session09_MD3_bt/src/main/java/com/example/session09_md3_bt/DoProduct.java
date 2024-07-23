package com.example.session09_md3_bt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoProduct", value = "/display-discount")
public class DoProduct extends HttpServlet {


    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String description  = request.getParameter("productDescription");
        double price = Double.parseDouble(request.getParameter("productPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("productDiscountPercent"));

        double discountAmount = discountPercent * price * 0.01;
        double discountPrice = price - discountAmount;


        request.setAttribute("productDescription",description);
        request.setAttribute("productPrice",price);
        request.setAttribute("productDiscountPercent",discountPercent);
        request.setAttribute("discountAmount",discountAmount);
        request.setAttribute("discountPrice",discountPrice);

        request.getRequestDispatcher("Result.jsp").forward(request,response);
    }

    public void destroy() {
    }
}