package com.yang.pagesTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yang.pagesTest.condition.LotteryConditon;
import com.yang.pagesTest.model.Lottery;
import com.yang.pagesTest.service.LotteryService;

@Controller
@RequestMapping("/page")
public class PageTestController {
	
	@Autowired
	private LotteryService lotteryService;
	
	@RequestMapping("/toPage")
	public ModelAndView toPageList(@RequestParam(defaultValue="1",required=false) int next){
		ModelAndView mav = new ModelAndView("list");
		LotteryConditon lc = new LotteryConditon();
		lc.setStart((next-1)*lc.getPer());
		List<Lottery> ls = lotteryService.getPartLottery(lc);
		int totalPages = lotteryService.getPageNum(lc);
		mav.addObject("lotterys", ls);
		mav.addObject("currentPage", next);
		mav.addObject("totalPages", totalPages);
		return mav;
	}
}
