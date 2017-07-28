package com.yang.pagesTest.condition;

import java.io.Serializable;

public class PageInfo implements Serializable {

	private static final long serialVersionUID = -5714567106290180708L;
	private int totals;
	private int per = 10;
	private int start;
	private int end;

	public int getTotals() {
		return totals;
	}

	public void setTotals(int totals) {
		this.totals = totals;
	}

	public int getPer() {
		return per;
	}

	public void setPer(int per) {
		this.per = per;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
