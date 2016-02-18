package com.hss.game.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

public class Sound {
	
	public static void play(File file,boolean isLoop) {
		InputStream inputStream;
		Player player;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			player=new Player(inputStream);
			player.play();
			while(isLoop){
				inputStream = new BufferedInputStream(new FileInputStream(file));
				player=new Player(inputStream);
				player.play();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void stop() {
		Thread thread=Thread.currentThread();
		thread.interrupt();
	}
	
	public static void main(String[] args) {
		File file=new File("image/music1.wav");
		play(file,true);
		
	}
}
