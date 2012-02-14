package com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Edge {
	float x1;
	float y1;
	float x2;
	float y2;
	
	
	
	transient Paint paint;
	public void onDraw(Canvas canvas) {
		paint = new Paint();
		paint.setColor(Color.WHITE);
		canvas.drawLine(x1, y1, x2, y2, paint);
	}
}
