package com.zhongruan.web;

import com.zhongruan.domain.User;
import com.zhongruan.service.UserService;
import com.zhongruan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");

        int sex;
        if (gender.equals("男")) {
            sex = 1;
        } else {
            sex = 2;
        }

        int role = 0;
        if (userRole.equals("管理员")) {
            role = 1;
        } else if (userRole.equals("经理")){
            role = 2;
        }else if (userRole.equals("普通用户")){
            role = 3;
        }
        String id = request.getParameter("id");
        Integer i = Integer.parseInt(id);
        User user = new User(i,userName,sex,birthday,phone,address,role);

        UserService service = new UserServiceImpl();
        service.updateUser(user);
        request.getRequestDispatcher("userList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
