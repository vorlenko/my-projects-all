package com.game;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Hero {
	float x;
	float y;
	
	transient Body body;

	public void onStart(World world){
		
		CircleShape shape = new CircleShape();
		shape.m_radius = 20.0f;

		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 1.0f;

		BodyDef bd = new BodyDef();
		bd.type = BodyType.DYNAMIC;
		bd.position.set(x,y);
		body = world.createBody(bd);
		body.createFixture(fd);
	}
	
	public void onDraw(Canvas canvas) {
		Paint paint = new Paint();

		Vec2 position = body.getPosition();
				
		paint.setColor(Color.RED);
		canvas.drawCircle(position.x, position.y, 20, paint);
	}




	Vec2 v=new Vec2(0,0);
	public void move(boolean up, boolean down,
			boolean left, boolean right) {
		float ax=0;
		float ay=0;
		if(up)   {ay=ay-100f;}
		if(down) {ay=ay+100f;}
		if(left) {ax=ax-100f;}
		if(right){ax=ax+100f;}
		
		v.set(ax, ay);
		body.setLinearVelocity(v);
		Vec2 p=body.getPosition();
		
		if(v.length()!=0){
			Log.d("move","vx="+v.x+" vy="+v.y+"x="+p.x+" y="+p.y);
			
		}
	}

	public void action(){}
}