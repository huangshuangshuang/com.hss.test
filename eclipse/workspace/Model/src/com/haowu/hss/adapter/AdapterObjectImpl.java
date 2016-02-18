package com.haowu.hss.adapter;

public class AdapterObjectImpl implements Adapter{
	
	private Targetable targetable;
	public AdapterObjectImpl(Targetable targetable) {
		this.targetable=targetable;
	}
	
	
	@Override
	public int sum(int a, int b) {
		return targetable.sum(a, b);
	}

	@Override
	public void week(String name) {
		targetable.week(name);
	}

	@Override
	public void die(String name) {
		targetable.die(name);
	}

	@Override
	public void doSomething(String name) {
		System.out.println("nothing");
	}

	@Override
	public void stop() {
		System.out.println("stop");
	}

}
