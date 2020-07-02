package com.zhongruan.service.impl;

import com.zhongruan.dao.AdminDao;
import com.zhongruan.dao.BillDao;
import com.zhongruan.dao.ProviderDao;
import com.zhongruan.dao.impl.AdminDaoImpl;
import com.zhongruan.dao.impl.BillDaoImpl;
import com.zhongruan.dao.impl.ProviderDaoImpl;
import com.zhongruan.domain.Bill;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.Provider;
import com.zhongruan.domain.User;
import com.zhongruan.service.BillService;

import java.util.List;
import java.util.Map;

public class BillServiceImpl implements BillService {
    BillDao dao =new BillDaoImpl();
    @Override
    public PageBean<Bill> getPageBean(String _currnetPage, String _rows, Map<String, String[]> map) {
        int currnetPage = Integer.parseInt(_currnetPage);
        int rows = Integer.parseInt(_rows);

        PageBean<Bill> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currnetPage);
        pageBean.setRows(rows);

        BillDao dao = new BillDaoImpl();
        int totalCount = dao.getTotalCount(map);
        pageBean.setTotalCount(totalCount);

        int totalPage = totalCount % rows == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pageBean.setTotalPage(totalPage);

        int start = rows * (currnetPage - 1);
        if(currnetPage > totalPage) {
            currnetPage = totalPage;
            start = rows * (totalPage - 1);
        }

        //获得单页数据
        List<Bill> list = dao.findBill(start, rows, map);
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public void deleteUserbyID(String id) {
        dao.deleteBillbyID(id);
    }

    @Override
    public Bill getBillbyID(String id) {
        return dao.getBillbyID(id);
    }

    @Override
    public Bill goUpdateBill(String id) {
        return dao.getBillbyID(id);
    }

    @Override
    public void updateBill(Bill bill) {
        dao.updateBill(bill);
    }

    @Override
    public void addBill(Bill bill) {

        dao.addBill(bill);
    }

    @Override
    public List<Provider> findPro() {
        ProviderDao pdao = new ProviderDaoImpl();
        return pdao.findPro();
    }


}
