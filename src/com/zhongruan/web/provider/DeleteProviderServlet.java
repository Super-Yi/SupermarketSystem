package com.zhongruan.web.provider;

import com.zhongruan.domain.Provider;
import com.zhongruan.service.ProviderService;
import com.zhongruan.service.UserService;
import com.zhongruan.service.impl.ProviderServiceImpl;
import com.zhongruan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProviderServlet")
public class DeleteProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        ProviderService service = new ProviderServiceImpl();
        service.deleteProviderbyID(id);
        request.getRequestDispatcher("providerList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
