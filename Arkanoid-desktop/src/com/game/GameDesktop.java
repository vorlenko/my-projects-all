package com.game;


import game.Game;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class GameDesktop {
	 public static void main (String[] argv) {
         new JoglApplication(new Game(), "Arkanoid", 480, 320, false);               
	 }
}
