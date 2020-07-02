package com.zhongruan.web;

import com.zhongruan.dao.AdminDao;
import com.zhongruan.dao.impl.AdminDaoImpl;
import com.zhongruan.domain.User;
import com.zhongruan.service.UserService;
import com.zhongruan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User admin = new User(name, password);
        UserService service = new UserServiceImpl();
        User user =service.getAdmin(admin);

        HttpSession session = request.getSession();
        session.setAttribute("admin", user);
        if (user != null) {
            request.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
