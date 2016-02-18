package com.hss.game.util;

import java.awt.Image;
import java.awt.Toolkit;

public class ImageFactory {
	private static Image[] images;
	private static Image[] bImages;

	/**
	 * 获取初始化地图元素图片
	 * 
	 * @param length 长度
	 * 
	 * @return
	 */
	public static Image[] getImages(int length) {
		images = new Image[length];
		for (int i = 0; i < length; i++) {
			images[i] = Toolkit.getDefaultToolkit().getImage("image/" + i + ".png");
		}
		return images;
	}

	/**
	 * 获取初始化按钮图片
	 * 
	 * @param length  图片个数
	 *            
	 * @return
	 */
	public static Image[] getBImages(int length) {
		bImages = new Image[length];
		for (int i = 0; i < length; i++) {
			bImages[i] = Toolkit.getDefaultToolkit().getImage("image/b" + (i+1) + ".jpg");
		}
		return bImages;
	}
}
