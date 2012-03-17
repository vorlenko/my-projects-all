package com.game;

import com.badlogic.gdx.InputProcessor;

public class Controls implements InputProcessor{

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		this.x=x;
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		return false;
	}

	int x=0;
	public int getX() {
		return x;
	}

}
