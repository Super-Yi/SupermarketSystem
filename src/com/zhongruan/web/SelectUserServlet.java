package com.zhongruan.web;

import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.User;
import com.zhongruan.service.UserService;
import com.zhongruan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserServlet")
public class SelectUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        } else if ("0".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        UserService serivce = new UserServiceImpl();
        Map<String,String[]> map = request.getParameterMap();
        PageBean<User> pageBean = serivce.getPageBean(currentPage, rows , map);

        request.setAttribute("pb", pageBean);
        request.setAttribute("map",map);
        request.getRequestDispatcher("userList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
