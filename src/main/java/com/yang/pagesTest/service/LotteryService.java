package com.yang.pagesTest.service;

import java.util.List;

import com.yang.pagesTest.condition.LotteryConditon;
import com.yang.pagesTest.model.Lottery;

public interface LotteryService {

	List<Lottery> getPartLottery(LotteryConditon lc);

	int getPageNum(LotteryConditon lc);
}
