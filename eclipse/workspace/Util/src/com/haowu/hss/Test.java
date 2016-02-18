package com.haowu.hss;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.haowu.hss.image.ImageUtil;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		test.test1();
	}

	public void test1() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date().toLocaleString());
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	public void test() {
		String arch = "C:\\Users\\300002\\Desktop\\1.jpg";
		String watermark = "C:\\Users\\300002\\Desktop/0.jpg";
		try {
			ImageUtil iUtil = ImageUtil.build(arch, watermark, null);
			iUtil.addWatermark(50, 0.7f, 1f, 0.01f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
