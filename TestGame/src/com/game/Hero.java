package com.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Hero {
	float x;
	float y;
	
	transient float vx=0;
	transient float vy=0;

	transient float ax=0;
	transient float ay=0;
	
	
	
	public void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		canvas.drawRect(x-20, y-20, x+20, y+20, paint);
	}





	public void move(boolean up, boolean down,
			boolean left, boolean right) {
		ax=0;
		ay=0;
		if(up)   {ay=ay-1;}
		if(down) {ay=ay+1;}
		if(left) {ax=ax-1;}
		if(right){ax=ax+1;}
	}





	public void action() {
		x=x+vx/7;
		y=y+vy/7;
		vx=vx+ax;
		vy=vy+ay;
		ax=ax*0.95f;
		ay=ay*0.95f;
		
		vx=vx*0.95f;
		vy=vy*0.95f;
	}
	
}