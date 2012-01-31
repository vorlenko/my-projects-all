package com.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class Game implements ApplicationListener {

	public void create() {}

	public void dispose() {}

	public void pause() {}

	public void render() {
		Gdx.gl.glClearColor(0.9f, 0, 0,1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	public void resize(int width, int height) {}

	public void resume() {}

}
