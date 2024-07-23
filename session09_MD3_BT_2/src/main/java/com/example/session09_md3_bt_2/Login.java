package com.example.session09_md3_bt_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    private String message;

    public void init() {
        message = "Login Fail!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
            request.setAttribute("username", username);

            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else {
            request.setAttribute("error", message);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    public void destroy() {
    }
}