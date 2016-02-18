package com.haowu.hss.facade;

public class BankImpl implements Bank {

	@Override
	public void inMoney() {
		System.out.println("银行存进1000万现金");
	}

	@Override
	public void outMoney() {
		System.out.println("银行损失1000万现金");
	}

}
