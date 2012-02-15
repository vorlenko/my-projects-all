package com.game;



import org.jbox2d.common.Vec2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;



public class Control {

	private Bitmap bmpBase;
	private Bitmap bmpKnob;
	private int bW=0;
	private int bH=0;
	private int kW=0;
	private int kH=0;
	public Control(View view) {
		bmpBase = BitmapFactory.decodeResource(view.getResources(), R.drawable.onscreen_control_base);
		bmpKnob = BitmapFactory.decodeResource(view.getResources(), R.drawable.onscreen_control_knob);

		bW=bmpBase.getWidth();
		bH=bmpBase.getHeight();
        kW=bmpKnob.getWidth();
		kH=bmpKnob.getHeight();
	}
		
			

	private int cH=0;
	//private int cW=0;
	public void onDraw(Canvas canvas){
		 cH=canvas.getHeight();
		 //cW=canvas.getWidth();
		
		canvas.drawBitmap(bmpBase, 0, cH-bH, null);
		canvas.drawBitmap(bmpKnob, bW/2-kW/2+x,cH-bH/2-kH/2+y, null);
	}

	
	private void correctLenght(){
		Vec2 v= new Vec2(x,y);
		if(v.length()>35){
			v.normalize();
			
			x=v.x*35;
			y=v.y*35;
			Log.d("x","x="+x);
			Log.d("y","y="+y);
		}
	}

	public float x=0;
	public float y=0;
	


	public boolean onTouchEvent(MotionEvent event) {
		int eventaction = event.getAction();
		switch (eventaction) {
        case MotionEvent.ACTION_DOWN: 
            x=event.getX()-bW/2;
            y=event.getY()-(cH-bH/2);
            correctLenght();
            break;

        case MotionEvent.ACTION_MOVE:
            x=event.getX()-bW/2;
            y=event.getY()-(cH-bH/2);
            correctLenght();
            break;

        case MotionEvent.ACTION_UP:   
            x=0;
            y=0;
            break;
		}
		return true;
	}

	

}
