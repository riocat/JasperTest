package com.yang.ireport.service.impl;

import com.yang.ireport.dao.SalesSlipMapper;
import com.yang.ireport.model.SalesSlip;
import com.yang.ireport.service.SalesSlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Service
public class SalesSlipServiceImpl implements SalesSlipService {

    @Autowired
    private SalesSlipMapper salesSlipMapper;

    @Override
    public List<SalesSlip> getList() {
        return salesSlipMapper.getList();
    }
}
