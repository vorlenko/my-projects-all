package com.game;

import java.util.ArrayList;

import android.graphics.Canvas;

public class Game {

	ArrayList<Level> levels;
	
	
	transient int currentLevel=0;
	
	public void onDraw(Canvas canvas){
		    levels.get(currentLevel).onDraw(canvas);
	}
}
