package com.zhongruan.domain;

import java.nio.channels.InterruptedByTimeoutException;

public class Bill {
    private int id;
    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private Integer productCount;
    private Integer totalPrice;
    private Integer isPayment;
    private String creationDate;
    private Integer providerId;
    private String proName;

    public Bill() {
    }

    public Bill(String billCode, String productName, String productUnit, Integer productCount, Integer totalPrice, Integer isPayment, Integer providerId) {
        this.billCode = billCode;
        this.productName = productName;
        this.productUnit = productUnit;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
        this.providerId = providerId;
    }

    public Bill(int id, String billCode, String productName, String productUnit, Integer productCount, Integer totalPrice, Integer isPayment) {
        this.id = id;
        this.billCode = billCode;
        this.productName = productName;
        this.productUnit = productUnit;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Integer isPayment) {
        this.isPayment = isPayment;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productCount='" + productCount + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", isPayment='" + isPayment + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", providerId='" + providerId + '\'' +
                ", proName='" + proName + '\'' +
                '}';
    }
}
