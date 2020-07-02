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

@WebServlet("/updateProviderServlet")
public class UpdateProviderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String proCode = request.getParameter("proCode");
        String proName = request.getParameter("proName");
        String proContact = request.getParameter("proContact");
        String proPhone = request.getParameter("proPhone");
        String proAddress = request.getParameter("proAddress");
        String proFax = request.getParameter("proFax");
        String proDesc = request.getParameter("proDesc");

        String id = request.getParameter("id");
        Integer i = Integer.parseInt(id);
        Provider provider = new Provider(i,proCode,proName,proDesc,proContact,proPhone,proAddress,proFax);

        ProviderService service = new ProviderServiceImpl();
        service.updateProvider(provider);
        request.getRequestDispatcher("providerList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
