package com.hss.game.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.hss.game.util.People;

public class ClassTest {
	public static void main(String[] args) {
		method4();
	}

	public static void method1() {
		String str = "abc";
		Class<?> cls1 = str.getClass();
		Class<?> cls2 = String.class;
		Class<?> cls3 = null;// 必须要加上null
		try {
			cls3 = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(cls1 == cls2);
		System.out.println(cls1 == cls3);

		System.out.println(cls1.isPrimitive());
		System.out.println(int.class.isPrimitive());// 判定指定的 Class 对象是否表示一个基本类型。
		System.out.println(int.class == Integer.class);
		System.out.println(int.class == Integer.TYPE);
		System.out.println(int[].class.isPrimitive());
		System.out.println(int[].class.isArray());
	}

	public static void method2() {
		try {
			Class<?> class1 = People.class;
			Class<?> c = Class.forName(People.class.getName());
			Method[] method = c.getMethods();
			Method[] intMethods = int.class.getMethods();
			Method[] methods = class1.getDeclaredMethods();
			for (int i = 0; i < method.length; i++) {
				System.out.println(method[i]);
			}
			for (int i = 0; i < methods.length; i++) {
				System.err.println(methods[i]);
			}
			for (int i = 0; i < intMethods.length; i++) {
				System.out.println(intMethods[i]);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void method3() {
		Field[] fields=People.class.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].toString());
		}
		try {
			Field field=People.class.getField("point");
			System.err.println(field.toGenericString());
			System.out.println(field.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void method4() {
		Class<?> c=ClassTestS.class;
		try {
			Method[] methods= c.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				System.out.println(methods[i]);
			}
			Method method=c.getMethod("method1");
			System.out.println(method.invoke(c.newInstance()));
			Method method2=c.getMethod("method4", int.class);
			//必须声明出要执行的方法所属的类的实例
			System.out.println(method2.invoke(c.newInstance(), new Integer(5)));;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
