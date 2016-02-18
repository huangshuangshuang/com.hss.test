package com.haowu.hss.facade;

public class MrsZhangImple implements MrsZhang {

	@Override
	public void make() {
		System.out.println("Mrs.Zhang把钱装进了麻袋");
	}

	@Override
	public void run() {
		System.out.println("Mrs.Zhang跳上了车");
	}

}
