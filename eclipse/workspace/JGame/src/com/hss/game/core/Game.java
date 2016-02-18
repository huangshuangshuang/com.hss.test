package com.hss.game.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.hss.game.util.GameMapFactory;
import com.hss.game.util.ImageFactory;
import com.hss.game.util.People;
import com.hss.game.util.SimpleImpleListener;
import com.hss.game.util.SimpleMouseListener;

public class Game extends SimpleImpleListener {

	private static final long serialVersionUID = -8540656120600638499L;
	private byte[][] map;
	private static int sum;
	private Image[] mImages;
	private Image[] bImages;
	private People people;
	private JButton[] jButton;
	private int checkpoint = 0;

	public Game() {
		setTitle("推箱子");
		setBackground(Color.BLACK);
		setSize(500, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sum = GameMapFactory.getCheckpoint();
		mImages = ImageFactory.getImages(5);
		bImages = ImageFactory.getBImages(3);
		init();
	}

	private void init() {
		map = GameMapFactory.getMap(checkpoint);// 得到初始化地图
		people = new People(map, getGraphics(), mImages, this);
		jButton = new JButton[3];
		
	}

	@Override
	public void paint(Graphics g) {
		int x = 50, y = 50;
		int w = mImages[0].getWidth(this) * 2 / 3;
		int h = mImages[0].getHeight(this) * 2 / 3;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				Image image = null;
				switch (map[j][i]) {
				case 0:
					image = mImages[0];
					break;
				case 1:
					image = mImages[1];
					break;
				case 2:
					image = mImages[2];
					break;
				case 4:
					image = mImages[3];
					break;
				case 5:
					image = mImages[4];
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
		int bh = bImages[0].getHeight(this);
		for (int n = 0; n < jButton.length; n++) {
			final int code = n;
			jButton[n] = new JButton("");
			jButton[n].setVisible(true);
			jButton[n].setBounds((int) (50 + (1 + 1.25 * n) * bw), y + h / 2, bw, bh);
			jButton[n].setIcon(new ImageIcon(bImages[n]));
			jButton[n].addMouseListener(new SimpleMouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goNext(code);
				}
			});
			getContentPane().add(jButton[n]);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			people.left();
			break;
		case KeyEvent.VK_RIGHT:
			people.right();
			break;
		case KeyEvent.VK_UP:
			people.up();
			break;
		case KeyEvent.VK_DOWN:
			people.down();
			break;
		default:
			break;
		}

	}

	private void goNext(int code) {
		switch (code) {
		case 0:
			if (checkpoint != 0) {
				checkpoint--;
				init();
				repaint();
				addKeyListener(this);	
				setFocusable(true);
			}
			break;
		case 1:
			if (checkpoint != sum) {
				checkpoint++;
				init();
				repaint();
				addKeyListener(this);	
				setFocusable(true);
			}
			break;
		case 2:
			this.dispose();
			break;

		default:
			break;
		}

	}

	public static void main(String[] args) {
		new Game();
	}

}
