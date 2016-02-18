package com.haowu.hss.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool<T> {
	private List<T> list;
	protected ThreadPool(){
		list=new ArrayList<T>();
	}
	public void add(T t){
		list.add(t);
	}
	public T get(int i){
		return list.get(i);
	}
	public T remove(int i){
		return list.remove(i);
	}

}
