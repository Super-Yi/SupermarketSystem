package com.zhongruan.web.ajax;

import com.zhongruan.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/passwordAjaxServlet")
public class PasswordAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String code = request.getParameter("password");
        HttpSession session = request.getSession();
        User admin = (User) session.getAttribute("admin");
        boolean flag;
        if (admin.getUserPassword().equals(code)) {
            flag = true;
        } else {
            flag = false;
        }
        response.getWriter().write(flag+"");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
