package com.haowu.hss.factory;

public class MailProvider implements Provider {

	@Override
	public Sender getSender() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}
