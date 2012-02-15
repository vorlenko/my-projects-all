package com.game;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Control {

	Bitmap bmpBase;
	Bitmap bmpKnob;
	
	public Control(View view) {
		bmpBase = BitmapFactory.decodeResource(view.getResources(), R.drawable.onscreen_control_base);
		bmpKnob = BitmapFactory.decodeResource(view.getResources(), R.drawable.onscreen_control_knob);
	}

	
	public void onDraw(Canvas canvas){
		int h1=canvas.getHeight();
		int w1=bmpBase.getWidth();
		int h2=bmpBase.getHeight();
		int w2=bmpKnob.getWidth();
		int h3=bmpKnob.getHeight();
		
		canvas.drawBitmap(bmpBase, 0, h1-h2, null);
		
		canvas.drawBitmap(bmpKnob, w1/2-w2/2, h1-h2/2-h3/2, null);
	}
}
