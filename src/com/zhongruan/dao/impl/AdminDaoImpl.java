package com.zhongruan.dao.impl;

import com.zhongruan.dao.AdminDao;
import com.zhongruan.domain.User;
import com.zhongruan.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdminDaoImpl implements AdminDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
    @Override
    public User getAdmin(User user) {
        String sql = "select * from smbms_user where userCode=? and userPassword = ?";
        List<User> list = template.query(sql,new BeanPropertyRowMapper<>(User.class), user.getUserCode(),user.getUserPassword());
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User CheckNameCode(String code) {
        String sql = "select * from smbms_user where userCode=?";
        List<User> list = template.query(sql,new BeanPropertyRowMapper<>(User.class),code);
        return list.get(0);
    }

    @Override
    public int getTotalCount(Map<String, String[]> map) {
        String sql = "select count(*) from smbms_user where 1 = 1 ";
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
    public List<User> findUser(int start, int rows, Map<String, String[]> map) {
        String sql = "select * from smbms_user where 1 = 1";
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
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), list.toArray());
    }

    @Override
    public List<User> getUser(String name ) {
        String sql = "select * from smbms_user where userCode=? and userPassword = ?";
        List<User> list = template.query(sql,new BeanPropertyRowMapper<>(User.class));
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    @Override
    public User getUserbyID(String id) {
        Integer i = Integer.parseInt(id);
        String sql = "select * from smbms_user where id=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),i);
        return user;
    }

    @Override
    public void deleteUserbyID(String id) {
        Integer i = Integer.parseInt(id);
        String sql = "delete from smbms_user where id=?";
        template.update(sql,i);
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into smbms_user(userCode,userName,userPassword,gender,birthday,phone,address,userRole) " +
                "value(?,?,?,?,?,?,?,?)";
        template.update(sql,user.getUserCode(),user.getUserName(),user.getUserPassword(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserRole());
    }

    @Override
    public void updatePassword(String password ,int id) {
        String sql = "update smbms_user set userPassword = ? where id = ?";
        template.update(sql,password,id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update smbms_user set userName=?,gender=?, birthday=?, phone=?, address=?, userRole=? where id=?";
        template.update(sql,user.getUserName(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserRole(),user.getId());
    }
}
