package com.hss.game.util;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BigJFrameTest extends JFrame implements KeyListener, MouseListener, WindowFocusListener {

	private static final long serialVersionUID = -5236787908556072658L;
	private int code = 0;
	private JButton button;

	public BigJFrameTest() {
		setAlwaysOnTop(true);
		setFocusable(true);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		setBackground(Color.BLUE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addKeyListener(this);
		button = new JButton("ÍË³ö");
		button.setVisible(false);
		button.addMouseListener(this);
		addWindowFocusListener(this);
		add(button);
	}

	public static void main(String[] args) {
		new BigJFrameTest();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.dispose();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		setVisible(true);
		setFocusable(true);
		setAlwaysOnTop(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_8 && code == 0) {
			code++;
		}
		if (e.getKeyCode() == KeyEvent.VK_5 && code == 1) {
			code++;
		}
		if (e.getKeyCode() == KeyEvent.VK_1 && code == 2) {
			code++;
		}
		if (e.getKeyCode() == KeyEvent.VK_3 && code == 3) {
			code++;
		}
		if (e.getKeyCode() == KeyEvent.VK_7 && code == 4) {
			code++;
		}
		if (e.getKeyCode() == KeyEvent.VK_8 && code == 5) {
			code++;
		}
		if (e.getKeyCode() == KeyEvent.VK_9 && code == 6) {
			code++;
		}
		if (e.getKeyCode() == KeyEvent.VK_4 && code == 7) {
			code++;
		}
		if (e.getKeyCode() == KeyEvent.VK_2 && code == 8) {
			code++;
		}
		if (code == 9) {
			button.setVisible(true);
		}
		if (e.getKeyCode() == (KeyEvent.VK_ALT|KeyEvent.VK_TAB)) {
			setVisible(true);
			setFocusable(true);
			setAlwaysOnTop(true);
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

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		setVisible(true);
		setFocusable(true);

	}

}
