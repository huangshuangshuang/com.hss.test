package com.hss.game.util;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameImpl extends JFrame {
	private static final long serialVersionUID = -6173144839917476675L;

	public JFrameImpl(String title, Color color, int width, int height) {

		setTitle(title);
		setSize(width, height);
		setBackground(color);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrameImpl(String title, Color color) {
		setTitle(title);
		setBackground(color);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrameImpl() {
		setTitle("²âÊÔ´°¿Ú");
		setBackground(Color.WHITE);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class JPanelImpl extends JPanel {

	private static final long serialVersionUID = 9158003251612412728L;

	public JPanelImpl() {
		JFrameImpl jFrameImpl = new JFrameImpl();
		setSize(700, 520);
		setVisible(true);
		jFrameImpl.getContentPane().add(this);
	}

}
