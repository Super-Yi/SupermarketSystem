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

@WebServlet("/updateBillServlet")
public class UpdateBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String billCode = request.getParameter("billCode");
        String productName = request.getParameter("productName");
        String productUnit = request.getParameter("productUnit");
        String productCount = request.getParameter("productCount");
        String totalPrice = request.getParameter("totalPrice");
        String isPayment = request.getParameter("isPayment");


        Integer productCount1 = Integer.parseInt(productCount);
        Integer totalPrice1 = Integer.parseInt(totalPrice);

        int isPayment1 = Integer.parseInt(isPayment);

        String id = request.getParameter("id");
        Integer i = Integer.parseInt(id);
        Bill bill = new Bill(i,billCode,productName,productUnit,productCount1,totalPrice1,isPayment1);

        BillService service = new BillServiceImpl();
        service.updateBill(bill);
        request.getRequestDispatcher("billList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
