package com.game;

import java.util.ArrayList;

import android.graphics.Canvas;

public class Level {

	ArrayList<Bound> bounds;
	
	Hero hero;
		
	public void onDraw(Canvas canvas) {
		for (Bound bound : bounds) {
		    bound.onDraw(canvas);
		}
	    hero.onDraw(canvas);
	}
}
