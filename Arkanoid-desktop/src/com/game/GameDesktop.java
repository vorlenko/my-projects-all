package com.game;



import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.game.Game;

public class GameDesktop {
	 public static void main (String[] argv) {
         new LwjglApplication(new Game(), "Arkanoid", 640, 640, false);               
	 }
}
