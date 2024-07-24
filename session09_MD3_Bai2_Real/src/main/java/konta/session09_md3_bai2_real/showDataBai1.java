package konta.session09_md3_bai2_real;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "showDataBai1", value = "/show-result")
public class showDataBai1 extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userId = "1";
        String userName = "Huấn";
        String userEmail = "huanrose@gmail.com";
        Integer userAge = 18;

        request.setAttribute("userId", userId);
        request.setAttribute("userName", userName);
        request.setAttribute("userEmail", userEmail);
        request.setAttribute("userAge", userAge);

        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    public void destroy() {
    }
}