package com.zhongruan.dao.impl;

import com.zhongruan.dao.BillDao;
import com.zhongruan.domain.Bill;
import com.zhongruan.domain.User;
import com.zhongruan.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BillDaoImpl implements BillDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
    @Override
    public List<Bill> findBill(int start, int rows, Map<String, String[]> map) {
        String sql = "select smbms_bill.id,smbms_bill.billCode,smbms_bill.productName," +
                "smbms_bill.productDesc,smbms_bill.productUnit,smbms_bill.productCount," +
                "smbms_bill.totalPrice,smbms_bill.isPayment,smbms_bill.creationDate,smbms_bill.providerId," +
                "smbms_provider.proName from smbms_bill," +
                "smbms_provider where smbms_bill.providerId = smbms_provider.id";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> set = map.keySet();
        List<Object> list = new ArrayList<>();
        for (String key : set) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = map.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key +  " like ? ");
                list.add("%" + value + "%");
            }
        }
        sb.append(" limit ? , ?");
        if(start<0)
        {
            start = 0;
            rows = 0;
        }
        list.add(start);
        list.add(rows);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Bill>(Bill.class), list.toArray());
    }

    @Override
    public int getTotalCount(Map<String, String[]> map) {
        String sql = "select count(*) from smbms_bill where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> set = map.keySet();
        List<Object> list = new ArrayList<>();
        for (String key : set) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = map.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key +  " like ? ");
                list.add("%" + value + "%");
            }
        }
        sql = sb.toString();
        return template.queryForObject(sql, Integer.class, list.toArray());
    }

    @Override
    public void deleteBillbyID(String id) {
        Integer i = Integer.parseInt(id);
        String sql = "delete from smbms_bill where id=?";
        template.update(sql,i);
    }

    @Override
    public Bill getBillbyID(String id) {
        Integer i = Integer.parseInt(id);
        String sql = "select * from smbms_bill where id=?";
        Bill bill = template.queryForObject(sql, new BeanPropertyRowMapper<Bill>(Bill.class),i);
        return bill;
    }


    @Override
    public void updateBill(Bill bill) {
        String sql = "update smbms_bill set billCode=?,productName=?, productUnit=?, productCount=?, totalPrice=?, isPayment=? where id=?";
        template.update(sql,bill.getBillCode(),bill.getProductName(),bill.getProductUnit(),bill.getProductCount(),bill.getTotalPrice(),bill.getIsPayment(),bill.getId());
    }

    @Override
    public void addBill(Bill bill) {
        String sql = "insert into smbms_bill(billCode,productName,productUnit,productCount,totalPrice,isPayment,creationDate, providerId) " +
                "value(?,?,?,?,?,?,now(),?)";
        template.update(sql,bill.getBillCode(),bill.getProductName(),bill.getProductUnit(),bill.getProductCount(),bill.getTotalPrice(),bill.getIsPayment(),bill.getProviderId());
    }
}
