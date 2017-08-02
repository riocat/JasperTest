package com.yang.ireport.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public class SalesSlipFactory {

    private static SalesSlip[] data;

    static {
        SalesSlipGoodsInfo ss1 = new SalesSlipGoodsInfo();
        ss1.setGoodsName("goodss1");
        ss1.setNum(1);
        ss1.setUnitPrice(new BigDecimal(1));
        ss1.setAmount(new BigDecimal(1));
        ss1.setRepertoryCode("仓库1");
        SalesSlipGoodsInfo ss2 = new SalesSlipGoodsInfo();
        ss2.setGoodsName("goodss2");
        ss2.setNum(2);
        ss2.setUnitPrice(new BigDecimal(2));
        ss2.setAmount(new BigDecimal(2));
        ss2.setRepertoryCode("仓库2");
        SalesSlipGoodsInfo ss3 = new SalesSlipGoodsInfo();
        ss3.setGoodsName("goodss3");
        ss3.setNum(3);
        ss3.setUnitPrice(new BigDecimal(3));
        ss3.setAmount(new BigDecimal(3));
        ss3.setRepertoryCode("仓库3");

        SalesSlip s1 = new SalesSlip();
        s1.setPurchaseOrderNum("000000000");
        s1.setSwitchToOrderNum("111111111");
        s1.setCustomer("客户1");
        List<SalesSlipGoodsInfo> list1 = new ArrayList<SalesSlipGoodsInfo>();
        list1.add(ss1);
        s1.setGoodsInfos(list1);
        SalesSlip s2 = new SalesSlip();
        s2.setPurchaseOrderNum("222222222");
        s2.setSwitchToOrderNum("333333333");
        s2.setCustomer("客户1");
        List<SalesSlipGoodsInfo> list2 = new ArrayList<SalesSlipGoodsInfo>();
        list2.add(ss2);
        list2.add(ss3);
        s2.setGoodsInfos(list2);
        data = new SalesSlip[]{s1,s2};
    }

    public static Object[] getBeanArray() {
        return data;
    }

    public static Collection<?> getBeanCollection() {
        return Arrays.asList(data);
    }
}
