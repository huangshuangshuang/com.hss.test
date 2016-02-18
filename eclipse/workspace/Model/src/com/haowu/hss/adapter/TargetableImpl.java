package com.haowu.hss.adapter;

public class TargetableImpl implements Targetable{

	@Override
	public int sum(int a, int b) {
		return a+b;
	}

	@Override
	public void week(String name) {
		System.out.println(name+"weak up");
	}

	@Override
	public void die(String name) {
		System.out.println(name+"was died");
	}

}
