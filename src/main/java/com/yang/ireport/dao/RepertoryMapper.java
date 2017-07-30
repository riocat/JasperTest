package com.yang.ireport.dao;

import com.yang.ireport.model.Repertory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ASUS on 2017/7/30.
 */
@Repository
public interface RepertoryMapper {

    List<Repertory> getList();
}
