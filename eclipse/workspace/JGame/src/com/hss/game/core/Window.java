package com.hss.game.core;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements Runnable, KeyListener {
	private int y = 0;
	private int x = 250;
	private long time = 0;
	private Image iImage;
	private Graphics iGraphics;

	private static final long serialVersionUID = 48414984149814991L;

	public Window() {
		Thread thread = new Thread(this);
		thread.start();
		//设置键盘的焦点在该window上
		setFocusable(true);
		//给window添加键盘事件
		addKeyListener(this);
	}

	@Override
	public void paint(Graphics g) {
		if (iImage == null) {
			iImage = createImage(this.getWidth(), this.getHeight());
			iGraphics = iImage.getGraphics();
		}
		iGraphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		iGraphics.setColor(Color.BLACK);
		iGraphics.fillOval(x, y, 10, 10);
		g.drawImage(iImage, 0, 0, this);
	}
/**
 * 重写JPanel的update方法
 */
	@Override
	public void update(Graphics g) {
		// super.update(g);
		paint(g);
	}

	@Override
	public void run() {

		Timer timer = new Timer(30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				y += 9.8 * 9.8 * time / 1000;
				time += 30;
				if (y > 500) {
					y = 0;
					time = 0;
				}
				repaint();
			}
		});
		timer.start();
	}

	public static void main(String[] args) {
		Window window = new Window();
		window.setSize(700, 500);
		window.setVisible(true);
		JFrame frame = new JFrame("小球落体运动");
		Container content = frame.getContentPane();
		content.add(window);
		frame.setBackground(Color.white);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
/*添加键盘按下事件
 * (non-Javadoc)
 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (x > 0) {
				x -= 10;
			}
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			if (x<700) {
				x+=10;
			}
			repaint();
			break;
			
		case KeyEvent.VK_UP:
			if (y>0) {
				y-=10;
			}
			repaint();
			break;
				
		case KeyEvent.VK_DOWN:
			if (y<500) {
				y+=10;
			}
			repaint();
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
}
