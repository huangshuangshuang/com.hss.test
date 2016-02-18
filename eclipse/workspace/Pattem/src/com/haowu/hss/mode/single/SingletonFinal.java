package com.haowu.hss.mode.single;

public class SingletonFinal {
	
	private static class SingleFactory{
		private static SingletonFinal singletonFinal=new SingletonFinal();
	}
	
	public static SingletonFinal build(){
		return SingleFactory.singletonFinal;
	}
	
	public Object raedResolve(){
		return build();
	}
}
