package com.haowu.hss.mode.imp;

public class Test {
	public static void main(String[] args) {
		String s="abcdcccd";
		String s2="abcdssssss";
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s.codePointAt(0));
		System.out.println(s.codePointAt(7));
	}
}
