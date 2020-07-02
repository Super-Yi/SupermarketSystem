package com.zhongruan.web.bill;

import com.zhongruan.domain.Bill;
import com.zhongruan.domain.Provider;
import com.zhongruan.service.BillService;
import com.zhongruan.service.ProviderService;
import com.zhongruan.service.impl.BillServiceImpl;
import com.zhongruan.service.impl.ProviderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addBillServlet")
public class AddBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String billCode = request.getParameter("billCode");
        String productName = request.getParameter("productName");
        String productUnit = request.getParameter("productUnit");
        String productCount = request.getParameter("productCount");
        String totalPrice = request.getParameter("totalPrice");
        String providerId = request.getParameter("proName");
        String isPayment = request.getParameter("isPayment");

        Integer productCount1 = Integer.parseInt(productCount);
        Integer totalPrice1 = Integer.parseInt(totalPrice);

        Integer providerId1 = Integer.parseInt(providerId);

        int isPayment1 = Integer.parseInt(isPayment);

        Bill bill = new Bill(billCode,productName,productUnit,productCount1,totalPrice1,isPayment1,providerId1);

        BillService service = new BillServiceImpl();
        service.addBill(bill);
        request.getRequestDispatcher("billList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
