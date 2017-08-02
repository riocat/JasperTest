package com.yang.ireport.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Administrator on 2017/8/2.
 */
public class SalesSlipGoodsInfoFactory {

    private static SalesSlipGoodsInfo[] data;

    static {
        SalesSlipGoodsInfo s1 = new SalesSlipGoodsInfo();
        s1.setGoodsName("goods1");
        s1.setNum(1);
        s1.setUnitPrice(new BigDecimal(1));
        s1.setAmount(new BigDecimal(1));
        s1.setRepertoryCode("仓库1");
        SalesSlipGoodsInfo s2 = new SalesSlipGoodsInfo();
        s2.setGoodsName("goods2");
        s2.setNum(2);
        s2.setUnitPrice(new BigDecimal(2));
        s2.setAmount(new BigDecimal(2));
        s2.setRepertoryCode("仓库2");
        SalesSlipGoodsInfo s3 = new SalesSlipGoodsInfo();
        s3.setGoodsName("goods3");
        s3.setNum(3);
        s3.setUnitPrice(new BigDecimal(3));
        s3.setAmount(new BigDecimal(3));
        s3.setRepertoryCode("仓库3");
        data = new SalesSlipGoodsInfo[]{s1,s2,s3};
    }

    public static Object[] getBeanArray() {
        return data;
    }

    public static Collection<?> getBeanCollection() {
        return Arrays.asList(data);
    }
}
