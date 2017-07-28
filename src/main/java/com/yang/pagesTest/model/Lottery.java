package com.yang.pagesTest.model;

import java.io.Serializable;

public class Lottery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3215315116530932283L;

	private int id;
	private int no;
	private int ball1;
	private int ball2;
	private int ball3;
	private int ball4;
	private int ball5;
	private int ball6;
	private int ball7;
	private String resultString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBall1() {
		return ball1;
	}

	public void setBall1(int ball1) {
		this.ball1 = ball1;
	}

	public int getBall2() {
		return ball2;
	}

	public void setBall2(int ball2) {
		this.ball2 = ball2;
	}

	public int getBall3() {
		return ball3;
	}

	public void setBall3(int ball3) {
		this.ball3 = ball3;
	}

	public int getBall4() {
		return ball4;
	}

	public void setBall4(int ball4) {
		this.ball4 = ball4;
	}

	public int getBall5() {
		return ball5;
	}

	public void setBall5(int ball5) {
		this.ball5 = ball5;
	}

	public int getBall6() {
		return ball6;
	}

	public void setBall6(int ball6) {
		this.ball6 = ball6;
	}

	public int getBall7() {
		return ball7;
	}

	public void setBall7(int ball7) {
		this.ball7 = ball7;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

}
