package com.yang.ireport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public class SalesSlip implements Serializable {

    private String objuid;
    private Date purchaseDate;
    private String purchaseOrderNum;
    private String switchToOrderNum;
    private String customer;
    private String taxCategories;
    private String historicalUnitPrice;
    private BigDecimal totalAmount;
    private BigDecimal totalNonTaxBaseCurrency;
    private String transactionMode;

    private List<SalesSlipGoodsInfo> goodsInfos;

    public String getObjuid() {
        return objuid;
    }

    public void setObjuid(String objuid) {
        this.objuid = objuid;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseOrderNum() {
        return purchaseOrderNum;
    }

    public void setPurchaseOrderNum(String purchaseOrderNum) {
        this.purchaseOrderNum = purchaseOrderNum;
    }

    public String getSwitchToOrderNum() {
        return switchToOrderNum;
    }

    public void setSwitchToOrderNum(String switchToOrderNum) {
        this.switchToOrderNum = switchToOrderNum;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTaxCategories() {
        return taxCategories;
    }

    public void setTaxCategories(String taxCategories) {
        this.taxCategories = taxCategories;
    }

    public String getHistoricalUnitPrice() {
        return historicalUnitPrice;
    }

    public void setHistoricalUnitPrice(String historicalUnitPrice) {
        this.historicalUnitPrice = historicalUnitPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalNonTaxBaseCurrency() {
        return totalNonTaxBaseCurrency;
    }

    public void setTotalNonTaxBaseCurrency(BigDecimal totalNonTaxBaseCurrency) {
        this.totalNonTaxBaseCurrency = totalNonTaxBaseCurrency;
    }

    public String getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(String transactionMode) {
        this.transactionMode = transactionMode;
    }

    public List<SalesSlipGoodsInfo> getGoodsInfos() {
        return goodsInfos;
    }

    public void setGoodsInfos(List<SalesSlipGoodsInfo> goodsInfos) {
        this.goodsInfos = goodsInfos;
    }
}
