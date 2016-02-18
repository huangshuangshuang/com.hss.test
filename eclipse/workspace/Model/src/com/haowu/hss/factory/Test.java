package com.haowu.hss.factory;

public class Test {
	public static void main(String[] args) {
		Provider provider=new SmsProvider();
		Sender sender=provider.getSender();
		sender.say();
	}
}
