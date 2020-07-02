package com.zhongruan.dao.impl;

import com.zhongruan.dao.ProviderDao;
import com.zhongruan.domain.Bill;
import com.zhongruan.domain.Provider;
import com.zhongruan.domain.User;
import com.zhongruan.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ProviderDaoImpl implements ProviderDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
    @Override
    public List<Provider> findProvider(int start, int rows, Map<String, String[]> map) {
        String sql = "select * from smbms_provider where 1 = 1";
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
        return template.query(sql, new BeanPropertyRowMapper<Provider>(Provider.class), list.toArray());
    }

    @Override
    public int getTotalCount(Map<String, String[]> map) {
        String sql = "select count(*) from smbms_provider where 1 = 1 ";
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
    public void deleteProviderbyID(String id) {
        Integer i = Integer.parseInt(id);
        String sql = "delete from smbms_provider where id=?";
        template.update(sql,i);
    }

    @Override
    public Provider getProviderbyID(String id) {
        Integer i = Integer.parseInt(id);
        String sql = "select * from smbms_provider where id=?";
        Provider provider = template.queryForObject(sql, new BeanPropertyRowMapper<Provider>(Provider.class),i);
        return provider;
    }

    @Override
    public void updateProvider(Provider provider) {
        String sql = "update smbms_provider set proCode=?,proName=?, proDesc=?, proContact=?, proPhone=?, proAddress=?,proFax=?where id=?";
        template.update(sql,provider.getProCode(),provider.getProName(),provider.getProDesc(),provider.getProContact(),provider.getProPhone(),provider.getProAddress(),provider.getProFax(),provider.getId());
    }

    @Override
    public void addProvider(Provider provider) {
        String sql = "insert into smbms_provider(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,creationDate) " +
                "value(?,?,?,?,?,?,?,now())";
        template.update(sql,provider.getProCode(),provider.getProName(),provider.getProDesc(),provider.getProContact(),provider.getProPhone(),provider.getProAddress(),provider.getProFax());
    }

    @Override
    public List<Provider> findPro() {
        String sql = "select * from smbms_provider";
        List<Provider> list = template.query(sql,new BeanPropertyRowMapper<>(Provider.class));
        return list;
    }
}
