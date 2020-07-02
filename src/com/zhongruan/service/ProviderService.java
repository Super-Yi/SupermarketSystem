package com.zhongruan.service;

import com.zhongruan.domain.Bill;
import com.zhongruan.domain.PageBean;
import com.zhongruan.domain.Provider;

import java.util.Map;

public interface ProviderService {
    PageBean<Provider> getPageBean(String currnetPage, String rows, Map<String,String[]> map);

    void deleteProviderbyID(String id);

    Provider getProviderbyID(String id);

    Provider goUpdateProvider(String id);

    void updateProvider(Provider provider);

    void addProvider(Provider provider);
}
