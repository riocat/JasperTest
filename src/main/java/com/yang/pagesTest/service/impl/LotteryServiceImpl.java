package com.yang.pagesTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.pagesTest.condition.LotteryConditon;
import com.yang.pagesTest.dao.LotteryMapper;
import com.yang.pagesTest.model.Lottery;
import com.yang.pagesTest.service.LotteryService;

@Service
public class LotteryServiceImpl implements LotteryService {

	@Autowired
	private LotteryMapper lotteryMapper;

	@Override
	public List<Lottery> getPartLottery(LotteryConditon lc) {
		// TODO Auto-generated method stub
		return lotteryMapper.getPartLottery(lc);
	}

	@Override
	public int getPageNum(LotteryConditon lc) {
		int num = lotteryMapper.getPageNum(lc);
		return num%lc.getPer()==0?num/lc.getPer():(num/lc.getPer()+1);
	}

}
