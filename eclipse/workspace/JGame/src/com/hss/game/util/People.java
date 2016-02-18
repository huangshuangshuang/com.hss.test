package com.hss.game.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public class People {
	private Point point;
	private DrawImage drawImage;
	private Graphics g;
	private Image[] images;
	private byte[][] b;
	private List<Point> list;

	public People(byte[][] b, Graphics g, Image[] images, ImageObserver observer) {
		this.g = g;
		this.b = b;
		this.images = images;
		getPeoplePoint();
		drawImage = new DrawImage(observer);
		list = new ArrayList<Point>();
	}

	/**
	 * images[0] 地板 images[1] 墙 images[2] 箱子 images[3] 目的地 images[4] 人
	 */
	/**
	 * 
	 */
	public void left() {
		int x = (int) point.getX();
		int y = (int) point.getY();
		int next = b[x - 1][y];
		switch (next) {
		case 0:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x - 1, y);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x - 1, y);
			}
			point.setLocation(x - 1, y);
			break;
		case 2:
			int type = b[x - 2][y];
			switch (type) {
			case 0:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x - 1, y);
					drawImage.paintPoint(g, images[2], x - 2, y);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x - 1, y);
					drawImage.paintPoint(g, images[2], x - 2, y);
				}
				point.setLocation(x - 1, y);
				break;
			case 4:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x - 1, y);
					drawImage.paintPoint(g, images[2], x - 2, y);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x - 1, y);
					drawImage.paintPoint(g, images[2], x - 2, y);
				}
				point.setLocation(x - 1, y);
				list.add(new Point(x - 2, y));
				break;
			case 5:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x - 1, y);
					drawImage.paintPoint(g, images[2], x - 2, y);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x - 1, y);
					drawImage.paintPoint(g, images[2], x - 2, y);
				}
				point.setLocation(x - 1, y);
				break;
			default:
				break;
			}
			break;

		case 4:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x - 1, y);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x - 1, y);
			}
			list.add(new Point(x - 1, y));
			point.setLocation(x - 1, y);
			break;
		case 5:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x - 1, y);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x - 1, y);
			}
			point.setLocation(x - 1, y);
			break;

		default:
			break;
		}
		
	}

	/**
	 * 向右移动
	 * 
	 * @param b
	 */
	public void right() {
		int x = (int) point.getX();
		int y = (int) point.getY();
		int next = b[x + 1][y];

		switch (next) {
		case 0:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x + 1, y);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x + 1, y);
			}
			point.setLocation(x + 1, y);
			break;
		case 2:
			int type = b[x + 2][y];
			switch (type) {
			case 0:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x + 1, y);
					drawImage.paintPoint(g, images[2], x + 2, y);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x + 1, y);
					drawImage.paintPoint(g, images[2], x + 2, y);
				}
				point.setLocation(x + 1, y);
				break;
			case 4:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x + 1, y);
					drawImage.paintPoint(g, images[2], x + 2, y);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x + 1, y);
					drawImage.paintPoint(g, images[2], x + 2, y);
				}

				list.add(new Point(x + 2, y));
				point.setLocation(x + 1, y);
				break;
			case 5:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x + 1, y);
					drawImage.paintPoint(g, images[2], x + 2, y);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x + 1, y);
					drawImage.paintPoint(g, images[2], x + 2, y);
				}
				point.setLocation(x + 1, y);
				break;
			default:
				break;
			}
			break;

		case 4:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x + 1, y);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x + 1, y);
			}
			point.setLocation(x + 1, y);
			list.add(new Point(x + 1, y));
			break;
		case 5:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x + 1, y);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x + 1, y);
			}
			point.setLocation(x + 1, y);
			break;

		default:
			break;
		}
		
	}

	/**
	 * 向上移动
	 * 
	 * @param b
	 */
	public void up() {
		int x = (int) point.getX();
		int y = (int) point.getY();
		int next = b[x][y - 1];

		switch (next) {
		case 0:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x, y - 1);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x, y - 1);
			}
			point.setLocation(x, y - 1);
			break;
		case 2:
			int type = b[x][y - 2];
			switch (type) {
			case 0:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x, y - 1);
					drawImage.paintPoint(g, images[2], x, y - 2);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x, y - 1);
					drawImage.paintPoint(g, images[2], x, y - 2);
				}
				point.setLocation(x, y - 1);
				break;
			case 4:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x, y - 1);
					drawImage.paintPoint(g, images[2], x, y - 2);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x, y - 1);
					drawImage.paintPoint(g, images[2], x, y - 2);
				}

				list.add(new Point(x, y - 2));
				point.setLocation(x, y - 1);
				break;
			case 5:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x, y - 1);
					drawImage.paintPoint(g, images[2], x, y - 2);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x, y - 1);
					drawImage.paintPoint(g, images[2], x, y - 2);
				}
				point.setLocation(x, y - 1);
				break;
			default:
				break;
			}
			break;

		case 4:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x, y - 1);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x, y - 1);
			}
			point.setLocation(x, y - 1);
			list.add(new Point(x, y - 1));
			break;
		case 5:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x, y - 1);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x, y - 1);
			}
			point.setLocation(x, y - 1);
			break;

		default:
			break;
		}
		
	}

	/**
	 * 向下移动
	 * 
	 * @param b
	 */
	public void down() {
		int x = (int) point.getX();
		int y = (int) point.getY();
		int next = b[x][y + 1];

		switch (next) {
		case 0:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x, y + 1);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x, y + 1);
			}
			point.setLocation(x, y + 1);
			break;
		case 2:
			int type = b[x][y + 2];
			switch (type) {
			case 0:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x, y + 1);
					drawImage.paintPoint(g, images[2], x, y + 2);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x, y + 1);
					drawImage.paintPoint(g, images[2], x, y + 2);
				}
				point.setLocation(x, y + 1);
				break;
			case 4:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x, y + 1);
					drawImage.paintPoint(g, images[2], x, y + 2);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x, y + 1);
					drawImage.paintPoint(g, images[2], x, y + 2);
				}
				point.setLocation(x, y + 1);
				list.add(new Point(x, y + 2));
				break;
			case 5:
				if (isDestination(x, y)) {
					drawImage.paintPoint(g, images[3], x, y);
					drawImage.paintPoint(g, images[4], x, y + 1);
					drawImage.paintPoint(g, images[2], x, y + 2);
				} else {
					drawImage.paintPoint(g, images[0], x, y);
					drawImage.paintPoint(g, images[4], x, y + 1);
					drawImage.paintPoint(g, images[2], x, y + 2);
				}
				point.setLocation(x, y + 1);
				break;
			default:
				break;
			}
			break;

		case 4:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x, y + 1);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x, y + 1);
			}
			point.setLocation(x, y + 1);
			list.add(new Point(y + 1, x));
			break;
		case 5:
			if (isDestination(x, y)) {
				drawImage.paintPoint(g, images[3], x, y);
				drawImage.paintPoint(g, images[4], x, y + 1);
			} else {
				drawImage.paintPoint(g, images[0], x, y);
				drawImage.paintPoint(g, images[4], x, y + 1);
			}
			point.setLocation(x, y + 1);
			break;

		default:
			break;
		}
		
	}

	public Point getPeoplePoint() {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j] == 5) {
					point = new Point(i, j);
				}
			}
		}
		return point;
	}

	/**
	 * 判断人当前站的是否是目的地
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isDestination(int x, int y) {
		for (Point point : list) {
			if (point.getX() == x && point.getY() == y) {
				return true;
			}
		}
		return false;
	}
}
