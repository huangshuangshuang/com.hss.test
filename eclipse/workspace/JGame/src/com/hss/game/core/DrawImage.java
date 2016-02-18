package com.hss.game.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.hss.game.util.JFrameImpl;

public class DrawImage extends JFrameImpl implements KeyListener {

	private static final long serialVersionUID = -3337831038156701838L;
	private Image[] images;
	private Image[] bImages;
	private int[][] init;
	private Point point;
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;

	public DrawImage() {
		super("ªÊª≠≤‚ ‘", Color.WHITE, 500, 600);
		setResizable(false);
		init();
		setFocusable(true);
		addKeyListener(this);
	}

	public void init() {
		images = new Image[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = Toolkit.getDefaultToolkit().getImage("image/" + i + ".png");
		}
		bImages = new Image[4];
		for (int i = 0; i < bImages.length; i++) {
			bImages[i] = Toolkit.getDefaultToolkit().getImage("image/b" + i + ".jpg");
		}
		init = new int[][] { { 3, 3, 1, 1, 1, 1, 1, 3, 3 }, { 3, 3, 1, 0, 0, 0, 1, 3, 3 },
				{ 1, 1, 1, 0, 0, 0, 1, 1, 1 }, { 1, 5, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 4, 0, 2, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 0, 0, 0, 1, 1 }, { 3, 1, 0, 0, 0, 0, 1, 1, 3 },
				{ 3, 1, 1, 1, 1, 1, 1, 3, 3 } };
	}

	@Override
	public void paint(Graphics g) {
		int x = 50, y = 50;
		int w = images[0].getWidth(this) * 2 / 3;
		int h = images[0].getHeight(this) * 2 / 3;
		for (int i = 0; i < init.length; i++) {
			for (int j = 0; j < init[0].length; j++) {
				Image image = null;
				switch (init[j][i]) {
				case 0:
					image = images[0];
					break;
				case 1:
					image = images[1];
					break;
				case 2:
					image = images[2];
					break;
				case 4:
					image = images[3];
					break;
				case 5:
					image = images[4];
				default:
					break;
				}
				g.drawImage(image, x, y, w, h, this);
				x += w;
			}
			x = 50;
			y += h;
		}
		int bw = bImages[0].getWidth(this);
		for (int i = 0; i < bImages.length; i++) {
			g.drawImage(bImages[i], (int) (25 + (1 + 1.25 * i) * bw), y + h / 2, this);
		}
		point = getPeoplePosition();
	}

	private void paintPoint(Graphics g, Image image, int x, int y) {
		g.clearRect(50 + x * image.getWidth(this) * 2 / 3, 50 + y * image.getHeight(this) * 2 / 3,
				image.getWidth(this) * 2 / 3, image.getHeight(this) * 2 / 3);
		g.drawImage(image, 50 + x * image.getWidth(this) * 2 / 3, 50 + y * image.getHeight(this) * 2 / 3,
				image.getWidth(this) * 2 / 3, image.getHeight(this) * 2 / 3, this);
	}

	private void right() {
		Graphics g = this.getGraphics();
		int x = (int) point.getX();
		int y = (int) point.getY();

		int type = init[x + 1][y];
		switch (type) {
		case 0:
			paintPoint(g, images[4], x + 1, y);
			paintPoint(g, images[0], x, y);
			point.setLocation(x + 1, y);
			break;
		case 2:
			int t = init[x + 2][y];
			switch (t) {
			case 0:
				paintPoint(g, images[2], x + 2, y);
				paintPoint(g, images[4], x + 1, y);
				paintPoint(g, images[0], x, y);
				point.setLocation(x + 1, y);
				break;
			case 4:
				paintPoint(g, images[2], x + 2, y);
				paintPoint(g, images[4], x + 1, y);
				paintPoint(g, images[0], x, y);
				point.setLocation(x + 1, y);
				break;
			case 5:
				paintPoint(g, images[2], x + 2, y);
				paintPoint(g, images[4], x + 1, y);
				paintPoint(g, images[0], x, y);
				point.setLocation(x + 1, y);
				break;
			default:
				break;
			}
			break;
		case 4:
			paintPoint(g, images[4], x + 1, y);
			paintPoint(g, images[3], x, y);
			point.setLocation(x + 1, y);
			break;
		case 5:
			paintPoint(g, images[4], x + 1, y);
			paintPoint(g, images[0], x, y);
			point.setLocation(x + 1, y);
			break;
		default:
			break;
		}

	}

	private void left() {
		Graphics g = this.getGraphics();
		int x = (int) point.getX();
		int y = (int) point.getY();

		int type = init[x - 1][y];
		switch (type) {
		case 0:
			paintPoint(g, images[4], x - 1, y);
			paintPoint(g, images[0], x, y);
			point.setLocation(x - 1, y);
			break;
		case 2:
			int t = init[x - 2][y];
			switch (t) {
			case 0:
				paintPoint(g, images[2], x - 2, y);
				paintPoint(g, images[4], x - 1, y);
				paintPoint(g, images[0], x, y);
				point.setLocation(x - 1, y);
				break;
			case 4:
				paintPoint(g, images[2], x - 2, y);
				paintPoint(g, images[4], x - 1, y);
				paintPoint(g, images[0], x, y);
				point.setLocation(x - 1, y);
				break;
			case 5:
				paintPoint(g, images[2], x - 2, y);
				paintPoint(g, images[4], x - 1, y);
				paintPoint(g, images[0], x, y);
				point.setLocation(x - 1, y);
				break;
			default:
				break;
			}
			break;
		case 4:
			paintPoint(g, images[4], x - 1, y);
			paintPoint(g, images[3], x, y);
			point.setLocation(x - 1, y);
			break;
		case 5:
			paintPoint(g, images[4], x - 1, y);
			paintPoint(g, images[0], x, y);
			point.setLocation(x - 1, y);
			break;
		default:
			break;
		}

	}

	private void up() {
		Graphics g = this.getGraphics();
		int x = (int) point.getX();
		int y = (int) point.getY();

		int type = init[x][y - 1];
		switch (type) {
		case 0:
			paintPoint(g, images[4], x, y - 1);
			paintPoint(g, images[0], x, y);
			point.setLocation(x, y - 1);
			break;
		case 2:
			int t = init[x][y - 2];
			switch (t) {
			case 0:
				paintPoint(g, images[2], x, y - 2);
				paintPoint(g, images[4], x, y - 1);
				paintPoint(g, images[0], x, y);
				point.setLocation(x, y - 1);
				break;
			case 4:
				paintPoint(g, images[2], x, y - 2);
				paintPoint(g, images[4], x, y - 1);
				paintPoint(g, images[0], x, y);
				point.setLocation(x, y - 1);
				break;
			case 5:
				paintPoint(g, images[2], x, y - 2);
				paintPoint(g, images[4], x, y - 1);
				paintPoint(g, images[0], x, y);
				point.setLocation(x, y - 1);
				break;
			default:
				break;
			}
			break;
		case 4:
			paintPoint(g, images[4], x, y - 1);
			paintPoint(g, images[3], x, y);
			point.setLocation(x, y - 1);
			break;
		case 5:
			paintPoint(g, images[4], x, y - 1);
			paintPoint(g, images[0], x, y);
			point.setLocation(x, y - 1);
			break;
		default:
			break;
		}

	}

	private void down() {
		Graphics g = this.getGraphics();
		int x = (int) point.getX();
		int y = (int) point.getY();

		int type = init[x][y + 1];
		switch (type) {
		case 0:
			paintPoint(g, images[4], x, y + 1);
			paintPoint(g, images[0], x, y);
			point.setLocation(x, y + 1);
			break;
		case 2:
			int t = init[x][y + 2];
			switch (t) {
			case 0:
				paintPoint(g, images[2], x, y + 2);
				paintPoint(g, images[4], x, y + 1);
				paintPoint(g, images[0], x, y);
				point.setLocation(x, y + 1);
				break;
			case 4:
				paintPoint(g, images[2], x, y + 2);
				paintPoint(g, images[4], x, y + 1);
				paintPoint(g, images[0], x, y);
				point.setLocation(x, y + 1);
				break;
			case 5:
				paintPoint(g, images[2], x, y + 2);
				paintPoint(g, images[4], x, y + 1);
				paintPoint(g, images[0], x, y);
				point.setLocation(x, y + 1);
				break;
			default:
				break;
			}
			break;
		case 4:
			paintPoint(g, images[4], x, y + 1);
			paintPoint(g, images[3], x, y);
			point.setLocation(x, y + 1);
			break;
		case 5:
			paintPoint(g, images[4], x, y + 1);
			paintPoint(g, images[0], x, y);
			point.setLocation(x, y + 1);
			break;
		default:
			break;
		}

	}

	private Point getPeoplePosition() {
		Point point = null;
		for (int i = 0; i < init.length; i++) {
			for (int j = 0; j < init[0].length; j++) {
				if (init[i][j] == 5) {
					point = new Point(i, j);
				}
			}
		}
		return point;
	}

	public static void main(String[] args) {
		new DrawImage();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left();
			break;
		case KeyEvent.VK_RIGHT:
			right();
			break;
		case KeyEvent.VK_UP:
			up();
			break;
		case KeyEvent.VK_DOWN:
			down();
			break;
		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	private void move(int moveDirection) {
		Graphics g = this.getGraphics();
		int x = (int) point.getX();
		int y = (int) point.getY();
		int type = 0;
		int t = 0;
		switch (moveDirection) {
		case LEFT:
			type = init[x - 1][y];
			t = init[x - 2][y];
			break;
		case RIGHT:
			type = init[x + 1][y];
			t = init[x + 2][y];
			break;
		case UP:
			type = init[x][y - 1];
			t = init[x][y - 2];
			break;
		case DOWN:
			type = init[x][y + 1];
			t = init[x][y + 2];
			break;
		default:
			break;
		}
		switch (type) {
		case 0:
			paintPoint(g, images[4], x, y + 1);
			paintPoint(g, images[0], x, y);
			point.setLocation(x, y + 1);
			break;
		case 2:
			switch (t) {
			case 0:
				paintPoint(g, images[2], y, x + 2);
				paintPoint(g, images[4], y, x + 1);
				paintPoint(g, images[0], y, x);
				point.setLocation(x, y + 1);
				break;
			case 4:
				paintPoint(g, images[2], x, y + 2);
				paintPoint(g, images[4], x, y + 1);
				paintPoint(g, images[0], x, y);
				point.setLocation(x, y + 1);
				break;
			case 5:
				paintPoint(g, images[2], x, y + 2);
				paintPoint(g, images[4], x, y + 1);
				paintPoint(g, images[0], x, y);
				point.setLocation(x, y + 1);
				break;
			default:
				break;
			}
			break;
		case 4:
			paintPoint(g, images[4], x, y + 1);
			point.setLocation(x, y + 1);
			break;
		case 5:
			paintPoint(g, images[4], x, y + 1);
			paintPoint(g, images[0], x, y);
			point.setLocation(x, y + 1);
			break;
		default:
			break;
		}
	}

}
