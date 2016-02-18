package com.haowu.hss.mode.imp;

public class LiMing implements People{

	@Override
	public void say() {
		System.out.println("say hello");
	}

	@Override
	public void eat() {
		System.out.println("eat food");
	}

	@Override
	public void sleep() {
		System.out.println("sleep");
	}
	
}
