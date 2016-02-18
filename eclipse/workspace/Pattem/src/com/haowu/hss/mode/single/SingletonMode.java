package com.haowu.hss.mode.single;

public class SingletonMode {
	private static SingletonMode singleMode;
	private SingletonMode(){}
	public static SingletonMode bulid(){
		if (singleMode==null) {
			singleMode=new SingletonMode();
		}
		return singleMode;
	}
}
