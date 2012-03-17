package com.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.game.Game;



public class GameDesktop {
	static LwjglApplication application;
	
	 public static void main (String[] argv) {
		 application = new LwjglApplication(new Game(), "Arkanoid", 480, 640, false);
	 }
}
