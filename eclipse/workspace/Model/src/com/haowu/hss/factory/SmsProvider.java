package com.haowu.hss.factory;

public class SmsProvider implements Provider {

	@Override
	public Sender getSender() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
