package com.yang.ireport.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/8/2.
 */
public class SalesSlipGoodsInfo implements Serializable {

    private String objuid;
    private String salesSslipId;
    private String goodsCode;
    private String goodsName;
    private String repertoryCode;
    private String batchNumberId;
    private int num;
    private BigDecimal unitPrice;
    private BigDecimal amount;
    private BigDecimal taxRate;
    private BigDecimal noTaxStandardCurrency;
    private BigDecimal tax;

    public String getObjuid() {
        return objuid;
    }

    public void setObjuid(String objuid) {
        this.objuid = objuid;
    }

    public String getSalesSslipId() {
        return salesSslipId;
    }

    public void setSalesSslipId(String salesSslipId) {
        this.salesSslipId = salesSslipId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getRepertoryCode() {
        return repertoryCode;
    }

    public void setRepertoryCode(String repertoryCode) {
        this.repertoryCode = repertoryCode;
    }

    public String getBatchNumberId() {
        return batchNumberId;
    }

    public void setBatchNumberId(String batchNumberId) {
        this.batchNumberId = batchNumberId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getNoTaxStandardCurrency() {
        return noTaxStandardCurrency;
    }

    public void setNoTaxStandardCurrency(BigDecimal noTaxStandardCurrency) {
        this.noTaxStandardCurrency = noTaxStandardCurrency;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}
