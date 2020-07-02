package com.zhongruan.service;

import com.zhongruan.domain.Bill;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.Provider;
import com.zhongruan.domain.User;

import java.util.List;
import java.util.Map;

public interface BillService {
    PageBean<Bill> getPageBean(String currnetPage, String rows, Map<String,String[]> map);

    void deleteUserbyID(String id);

    Bill getBillbyID(String id);

    Bill goUpdateBill(String id);

    void updateBill(Bill bill);

    void addBill(Bill bill);

    List<Provider> findPro();
}
