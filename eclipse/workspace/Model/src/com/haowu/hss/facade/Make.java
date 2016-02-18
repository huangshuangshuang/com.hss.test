package com.haowu.hss.facade;

public class Make {
	private Bank bank;
	private MrsWang mrsWang;
	private MrsZhang mrsZhang;
	public Make() {
		bank=new BankImpl();
		mrsWang=new MrsWangImpl();
		mrsZhang=new MrsZhangImple();
	}
	public void make(){
		System.out.println("Mrs.Zhang和Mrs.Wang想要打劫银行");
		bank.inMoney();
		mrsWang.make();
		mrsZhang.make();
		mrsWang.run();
		mrsZhang.run();
		bank.outMoney();
		System.out.println("银行被抢劫了");
	}
}
