package com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bound {
	Point begin;
	Point end;
	
	
	transient Paint paint;
	public void onDraw(Canvas canvas) {
		paint = new Paint();
		paint.setColor(Color.WHITE);
		canvas.drawLine(begin.x, begin.y, end.x, end.y, paint);
	}
}
