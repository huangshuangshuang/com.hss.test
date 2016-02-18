package com.haowu.hss.mode.single;

public class Singleton {
	private static Singleton single=new Singleton();
	private Singleton(){}
	public static Singleton build(){
		return single;
	}
}
