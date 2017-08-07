package com.yang.ireport.dao;

import com.yang.ireport.model.SalesSlip;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Repository
public interface SalesSlipMapper {

    List<SalesSlip> getList();
}
