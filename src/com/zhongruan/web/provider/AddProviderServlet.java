package com.zhongruan.web.provider;

import com.zhongruan.domain.Provider;
import com.zhongruan.domain.User;
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

@WebServlet("/addProviderServlet")
public class AddProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String proCode = request.getParameter("proCode");
        String proName = request.getParameter("proName");
        String proDesc = request.getParameter("proDesc");
        String proContact = request.getParameter("proContact");
        String proPhone = request.getParameter("proPhone");
        String proAddress = request.getParameter("proAddress");
        String proFax = request.getParameter("proFax");

        Provider provider = new Provider(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax);

        ProviderService service = new ProviderServiceImpl();
        service.addProvider(provider);
        request.getRequestDispatcher("userList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
