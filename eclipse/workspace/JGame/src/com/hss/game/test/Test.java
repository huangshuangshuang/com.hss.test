package com.hss.game.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	private static List<String[]> list;

	private static void init(){
		list = new ArrayList<String[]>();
	}
	
	public static void getChar(int number) {
		switch (number) {
		case 0:
			String[] s1=new String[]{"a","b","c"};
			list.add(s1);
			break;
		case 1:
			String[] s2=new String[]{"d","e","f"};
			list.add(s2);
			break;
		case 2:
			String[] s3=new String[]{"j","h","i"};
			list.add(s3);
			break;
		case 3:
			String[] s4=new String[]{"g","k","l"};
			list.add(s4);
			break;
		case 4:
			String[] s5=new String[]{"m","n","o"};
			list.add(s5);
			break;
		case 5:
			String[] s6=new String[]{"p","q","r"};
			list.add(s6);
			break;
		case 6:
			String[] s7=new String[]{"s","t","u","v"};
			list.add(s7);
			break;
		case 7:
			String[] s8=new String[]{"w","x","y","z"};
			list.add(s8);
			break;
		case 8:
			String[] s9=new String[]{"0","1","2","3","4"};
			list.add(s9);
			break;
		case 9:
			String[] s10=new String[]{"5","6","7","8","9"};
			list.add(s10);
			break;
		default:
			String[] s0=new String[]{"*"};
			list.add(s0);
			break;
		}
	}
	
	public static String[] getS() {
		for (int i = 0; i < list.size()-1; i++) {
			list.set(i+1,getArrayValue(list.get(i),list.get(i+1)));
		}
		return list.get(list.size()-1);
	}

	public static String[] getArrayValue(String[] s1, String[] s2) {
		String[] strings = new String[s1.length * s2.length];
		int code=0;
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				strings[code++] = s1[i] + s2[j];
			}
		}
		return strings;
	}

	public static void main(String[] args) {
		init();
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入数字：");
		String number=scanner.next();
		System.err.println("正在计算，请稍等...");
		for (int i = 0; i < number.length(); i++) {
			getChar(Integer.parseInt(String.valueOf(number.charAt(i))));
		}
		String[] string2=getS();
		System.err.println("计算完成，共有"+string2.length+"个结果，分别如下：");
		for (int i = 0; i < string2.length; i++) {
			System.out.println(string2[i]);
		}
		
	}
}
