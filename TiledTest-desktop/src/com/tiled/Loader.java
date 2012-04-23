package com.tiled;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.tiled.Game;

public class Loader {
	public static void main (String[] args) {
        new LwjglApplication(new Game(), "TiledTest", 1024, 512, false);
	}
}
