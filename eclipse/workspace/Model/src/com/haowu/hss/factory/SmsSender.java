package com.haowu.hss.factory;

public class SmsSender implements Sender {

	@Override
	public void say() {
		System.out.println("sms");
	}

}
