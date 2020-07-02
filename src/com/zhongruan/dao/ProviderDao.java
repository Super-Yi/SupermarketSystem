package com.zhongruan.dao;

import com.zhongruan.domain.Bill;
import com.zhongruan.domain.Provider;
import com.zhongruan.domain.User;

import java.util.List;
import java.util.Map;

public interface ProviderDao {
    List<Provider> findProvider(int start, int rows, Map<String, String[]> map);

    int getTotalCount(Map<String, String[]> map);

    void deleteProviderbyID(String id);

    Provider getProviderbyID(String id);

    void updateProvider(Provider provider);

    void addProvider(Provider provider);

    List<Provider> findPro();
}
