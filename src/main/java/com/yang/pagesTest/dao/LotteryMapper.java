package com.yang.pagesTest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yang.pagesTest.condition.LotteryConditon;
import com.yang.pagesTest.model.Lottery;

@Repository
public interface LotteryMapper {

	List<Lottery> getPartLottery(LotteryConditon lc);

	int getPageNum(LotteryConditon lc);
	
}
