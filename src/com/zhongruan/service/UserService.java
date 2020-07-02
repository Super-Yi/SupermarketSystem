package com.zhongruan.service;

import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.User;

import java.util.Map;

public interface UserService {
    boolean CheckNameCode(String code);

    User getAdmin(User admin);

    void updateUser(User user);

    PageBean<User> getPageBean(String currnetPage, String rows, Map<String,String[]> map);

    User getUserbyID(String id);

    User goUpdateUser(String id);

    void deleteUserbyID(String id);

    void addUser(User user);

    void updatePassword(String password, int id);
}
