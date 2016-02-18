package com.haowu.hss;

public class ThreadTest {

	public static void main(String[] args) {
		final Integer a = 1;
		final Integer b = 2;
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					synchronized (a) {
						System.out.println(b);
						
					}
				}
			}

		});

		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					synchronized (b) {
						System.out.println(a);
					}
				}

			}
		};
		thread.start();
		thread1.start();
	}

}
