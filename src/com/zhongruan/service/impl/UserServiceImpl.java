package com.zhongruan.service.impl;

import com.zhongruan.dao.AdminDao;
import com.zhongruan.dao.BillDao;
import com.zhongruan.dao.impl.AdminDaoImpl;
import com.zhongruan.dao.impl.BillDaoImpl;
import com.zhongruan.domain.Bill;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.User;
import com.zhongruan.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    AdminDao dao =new AdminDaoImpl();
    @Override
    public boolean CheckNameCode(String code) {
        return dao.CheckNameCode(code) != null;
    }

    @Override
    public User getAdmin(User admin) {
        return dao.getAdmin(admin);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public PageBean<User> getPageBean(String _currnetPage, String _rows, Map<String, String[]> map) {
        int currnetPage = Integer.parseInt(_currnetPage);
        int rows = Integer.parseInt(_rows);

        PageBean<User> pageBean = new PageBean<>();
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
        List<User> list = dao.findUser(start, rows, map);
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public User getUserbyID(String id) {
        return dao.getUserbyID(id);
    }

    @Override
    public User goUpdateUser(String id) {
        return dao.getUserbyID(id);
    }

    @Override
    public void deleteUserbyID(String id) {
        dao.deleteUserbyID(id);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void updatePassword(String password,int id) {
        dao.updatePassword(password ,id);
    }

}
