package com.game;



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


	public float x=0;
	public float y=0;
	


	public boolean onTouchEvent(MotionEvent event) {
		int eventaction = event.getAction();
		switch (eventaction) {
        case MotionEvent.ACTION_DOWN: 
            x=event.getX()-bW/2;
            y=event.getY()-(cH-bH/2);
            break;

        case MotionEvent.ACTION_MOVE:
            x=event.getX()-bW/2;
            y=event.getY()-(cH-bH/2);
            break;

        case MotionEvent.ACTION_UP:   
            x=0;
            y=0;
            break;
		}
		Log.d("touch","x="+x+" y="+y);
		return true;
	}

	

}
