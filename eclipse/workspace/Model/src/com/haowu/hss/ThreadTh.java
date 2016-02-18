package com.haowu.hss;

public class ThreadTh {
	private int sum=0;
	public void add(int value){
		sum+=value;
		System.out.println(sum);
	}
}
