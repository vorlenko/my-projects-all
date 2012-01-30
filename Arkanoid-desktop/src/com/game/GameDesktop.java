package com.game;


import game.Game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class GameDesktop {
	 public static void main (String[] argv) {
         new LwjglApplication(new Game(), "Arkanoid", 640, 640, false);               
	 }
}
