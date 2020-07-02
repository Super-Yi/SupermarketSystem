package com.zhongruan.web.bill;

import com.zhongruan.domain.Bill;
import com.zhongruan.domain.User;
import com.zhongruan.service.BillService;
import com.zhongruan.service.UserService;
import com.zhongruan.service.impl.BillServiceImpl;
import com.zhongruan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goLookBillServlet")
public class GoLookBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String proName = request.getParameter("proName");
        BillService service = new BillServiceImpl();
        Bill bill =service.getBillbyID(id);
        request.setAttribute("bill",bill);
        request.setAttribute("proName",proName);
        request.getRequestDispatcher("billView.jsp").forward(request,response);
    }
}
