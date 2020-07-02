package com.zhongruan.service.impl;

import com.zhongruan.dao.BillDao;
import com.zhongruan.dao.ProviderDao;
import com.zhongruan.dao.impl.BillDaoImpl;
import com.zhongruan.dao.impl.ProviderDaoImpl;
import com.zhongruan.domain.Bill;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.Provider;
import com.zhongruan.service.ProviderService;

import java.util.List;
import java.util.Map;

public class ProviderServiceImpl implements ProviderService {
    ProviderDao dao =new ProviderDaoImpl();
    @Override
    public PageBean<Provider> getPageBean(String _currnetPage, String _rows, Map<String, String[]> map) {
        int currnetPage = Integer.parseInt(_currnetPage);
        int rows = Integer.parseInt(_rows);

        PageBean<Provider> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currnetPage);
        pageBean.setRows(rows);

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
        List<Provider> list = dao.findProvider(start, rows, map);
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public void deleteProviderbyID(String id) {
        dao.deleteProviderbyID(id);
    }

    @Override
    public Provider getProviderbyID(String id) {
        return dao.getProviderbyID(id);
    }

    @Override
    public Provider goUpdateProvider(String id) {
        return dao.getProviderbyID(id);
    }

    @Override
    public void updateProvider(Provider provider) {
        dao.updateProvider(provider);
    }

    @Override
    public void addProvider(Provider provider) {
        dao.addProvider(provider);
    }
}
