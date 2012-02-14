package com.game;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Hero {
	private static final float PIXEL2METER_RATIO = 300;
	float x;
	float y;
	
	transient Body body;
	transient BodyDef bodyDef;

	public void onStart(World world){
/*
		bodyDef = new BodyDef();  
        bodyDef.position.set(x,y);  
        body = world.createBody(bodyDef);
        
        // Create Shape with Properties  
        CircleDef circle = new CircleDef();  
        circle.radius = (float) 20.0f/PIXEL2METER_RATIO;  
        circle.density = (float) 1.0; 
        circle.restitution=0.5f;
        
        body.createShape(circle);
        body.setMassFromShapes();
  */      

	}
	
	//Vec2 position;
	Paint paint = new Paint();
	public void onDraw(Canvas canvas) {
/*
		position = body.getPosition();
				
		paint.setColor(Color.RED);
		canvas.drawCircle(10+position.x*PIXEL2METER_RATIO, position.y*PIXEL2METER_RATIO+10, 20, paint);//drawRect(x-20, y-20, x+20, y+20, paint);
*/
	}





	float ax=0;
	float ay=0;
	public void move(boolean up, boolean down,
			boolean left, boolean right) {
/*
		ax=0;
		ay=0;
		if(up)   {ay=ay-1f;}
		if(down) {ay=ay+1f;}
		if(left) {ax=ax-1f;}
		if(right){ax=ax+1f;}
		
		Vec2 v=new Vec2(ax,ay);
		body.applyImpulse(v, new Vec2(0,0));
		Vec2 p=body.getPosition();
		
		if(v.length()!=0){
			Log.d("move","vx="+v.x+" vy="+v.y+"x="+p.x+" y="+p.y);
			
		}
*/
	}

	public void action(){}
}