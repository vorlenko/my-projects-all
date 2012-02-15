package com.game;

import android.graphics.Canvas;
import android.util.Log;

public class Camera {
	
	public float x=0;
	public float y=0;
	
	public Camera(){
		this.x=0;
		this.y=0;
	}
	
	public void set(float x,float y){
		this.x=x;
		this.y=y;
	}

	public void apply(Canvas canvas){
		Log.d("camera","x="+x+" y="+y);
		canvas.translate(-x, -y);
	}
	
	public void apply(Canvas canvas,float x,float y){
		canvas.translate(x,y);
	}

}
