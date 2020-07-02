package com.zhongruan.web;

import com.zhongruan.domain.User;
import com.zhongruan.service.UserService;
import com.zhongruan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("admin");
        UserService service = new UserServiceImpl();
        service.updatePassword(password,user.getId());
        response.sendRedirect("login.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
