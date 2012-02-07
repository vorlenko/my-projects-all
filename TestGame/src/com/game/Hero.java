package com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Hero {
	float x;
	float y;
	
	
	
	public void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		canvas.drawRect(x-20, y-20, 40, 40, paint);
	}
	
}