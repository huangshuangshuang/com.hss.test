package com.hss.game.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class DrawImage {
	private ImageObserver observer;

	public DrawImage(ImageObserver observer) {
		this.observer = observer;
	}

	public void paintPoint(Graphics g, Image image, int x, int y) {
		g.clearRect(50 + x * image.getWidth(observer) * 2 / 3, 50 + y * image.getHeight(observer) * 2 / 3,
				image.getWidth(observer) * 2 / 3, image.getHeight(observer) * 2 / 3);
		g.drawImage(image, 50 + x * image.getWidth(observer) * 2 / 3, 50 + y * image.getHeight(observer) * 2 / 3,
				image.getWidth(observer) * 2 / 3, image.getHeight(observer) * 2 / 3, observer);
	}
}
