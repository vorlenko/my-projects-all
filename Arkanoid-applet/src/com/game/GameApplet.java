package com.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplet;
import com.game.Game;


public class GameApplet extends  LwjglApplet{

	private static final long serialVersionUID = 1L;

	public GameApplet(){
		super(new Game(),false);
	}
}
