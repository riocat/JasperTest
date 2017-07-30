package com.yang.ireport.service.impl;

import com.yang.ireport.dao.RepertoryMapper;
import com.yang.ireport.model.Repertory;
import com.yang.ireport.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2017/7/30.
 */
@Service
public class RepertoryServiceImpl implements RepertoryService{

    @Autowired
    private RepertoryMapper repertoryMapper;

    @Override
    public List<Repertory> getList() {
        return repertoryMapper.getList();
    }
}
