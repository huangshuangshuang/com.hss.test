package com.haowu.hss;

import java.util.HashMap;

public class MyMap<K,V> extends HashMap<K, V>{
	
	private static final long serialVersionUID = 1485414518151L;
	
	public V getOrDefault(K key,V defaultValue){
		V v=get(key);
		if (v==null) {
			v=defaultValue;
		}
		return v;
	}
	
	
	public static void main(String[] args) {
		MyMap<String, Object> map=new MyMap<String, Object>();
		map.put("name", "刘星");
		Object object=map.getOrDefault("sex", "男");
		System.out.println(object);
	}
}
