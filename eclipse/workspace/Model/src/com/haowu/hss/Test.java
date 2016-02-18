package com.haowu.hss;

import com.haowu.hss.adapter.Adapter;
import com.haowu.hss.adapter.AdapterImpl;
import com.haowu.hss.adapter.AdapterObjectImpl;
import com.haowu.hss.adapter.Targetable;
import com.haowu.hss.adapter.TargetableImpl;
import com.haowu.hss.facade.Make;
import com.haowu.hss.factory.Provider;
import com.haowu.hss.factory.Sender;
import com.haowu.hss.factory.SmsProvider;

public class Test {
	public static void main(String[] args) {
		Test test=new Test();
		test.tes();
	}
	/**
	 * 适配器模式
	 */
	public void adapter() {
		Adapter adapter=new AdapterImpl();
		adapter.die("zhangsan");
		System.out.println(adapter.sum(1, 2));
		adapter.week("zhangsan");
	}
	/**
	 * 工厂模式
	 */
	public void factory() {
		Provider provider=new SmsProvider();
		Sender sender=provider.getSender();
		sender.say();
	}
	
	public void adapterObject() {
		Targetable able=new TargetableImpl();
		Adapter adapter=new AdapterObjectImpl(able);
		adapter.die("zhangsan");
		System.out.println(adapter.sum(1, 2));
		adapter.week("zhangsan");
	}
	/**
	 * 外观模式
	 */
	public void facade(){
		Make make=new Make();
		make.make();
	}
	public void tes(){
		String regString="^([0-9]{1,})((\\.)([0-9]{1,2})|([0-9]{0}))$";
		System.out.println("125".matches(regString));
		
	}
}
