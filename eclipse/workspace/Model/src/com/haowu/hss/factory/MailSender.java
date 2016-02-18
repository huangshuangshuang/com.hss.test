package com.haowu.hss.factory;

public class MailSender implements Sender {

	@Override
	public void say() {
		System.out.println("mail");
	}

}
