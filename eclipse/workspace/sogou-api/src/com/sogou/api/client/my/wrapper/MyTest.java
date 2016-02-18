package com.sogou.api.client.my.wrapper;

public class MyTest {
	private static Long id;

	public static void main(String[] args) {
		Long id3 = new Long(100000000000L);
		Long id4 = new Long(100000000000L);
		MyTest myTest = new MyTest();
		id = 100000000000L;
		System.out.println(id3.equals(id4));
		System.out.println(myTest.equals(id3));
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(obj);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
