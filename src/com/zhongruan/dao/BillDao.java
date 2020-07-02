package com.zhongruan.dao;

import com.zhongruan.domain.Bill;
import com.zhongruan.domain.User;

import java.util.List;
import java.util.Map;

public interface BillDao {
    List<Bill> findBill(int start, int rows, Map<String, String[]> map);

    int getTotalCount(Map<String, String[]> map);

    void deleteBillbyID(String id);

    Bill getBillbyID(String id);


    void updateBill(Bill bill);

    void addBill(Bill bill);
}
