package com.zhongruan.dao;

import com.zhongruan.domain.User;

import java.util.List;
import java.util.Map;

public interface AdminDao {

    User getAdmin(User admin);

    User CheckNameCode(String code);

    void updateUser(User user);

    int getTotalCount(Map<String, String[]> map);

    List<User> findUser(int start, int rows, Map<String, String[]> map);

    List<User> getUser(String name );

    User getUserbyID(String id);

    void deleteUserbyID(String id);

    void addUser(User user);

    void updatePassword(String password,int id);
}
