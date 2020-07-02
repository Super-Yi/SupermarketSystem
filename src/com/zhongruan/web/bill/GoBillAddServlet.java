package com.zhongruan.web.bill;

import com.zhongruan.domain.Bill;
import com.zhongruan.domain.Provider;
import com.zhongruan.service.BillService;
import com.zhongruan.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/goBillAddServlet")
public class GoBillAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        BillService service = new BillServiceImpl();
        List<Provider> list =service.findPro();

        request.setAttribute("list",list);
        request.getRequestDispatcher("billAdd.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
