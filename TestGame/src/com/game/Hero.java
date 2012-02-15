package com.game;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.MassData;
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
	public static final float PIXEL2METER_RATIO = 10;
	float x;
	float y;
	
	transient Body body;

	public void onStart(World world){
		
		CircleShape shape = new CircleShape();

		shape.m_radius = 20.0f/PIXEL2METER_RATIO;

		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.density = 1.0f;
		fd.restitution=0;
		
		BodyDef bd = new BodyDef();
		bd.type = BodyType.DYNAMIC;
		bd.position.set(x/PIXEL2METER_RATIO,y/PIXEL2METER_RATIO);
		body = world.createBody(bd);
		body.createFixture(fd);
		
	}
	
	public void onDraw(Canvas canvas) {
		Paint paint = new Paint();

		Vec2 position = body.getPosition();
				
		paint.setColor(Color.RED);
		canvas.drawCircle(position.x*PIXEL2METER_RATIO, position.y*PIXEL2METER_RATIO, 20, paint);
	}





	Vec2 v=new Vec2(0,0);
	public void move(boolean up, boolean down,
			boolean left, boolean right) {
		float ax=0;
		float ay=0;
		if(up)   {ay=ay-10f/PIXEL2METER_RATIO;}
		if(down) {ay=ay+10f/PIXEL2METER_RATIO;}
		if(left) {ax=ax-10f/PIXEL2METER_RATIO;}
		if(right){ax=ax+10f/PIXEL2METER_RATIO;}
		
		v.set(ax, ay);
		//if(v.length()>0){
			body.applyLinearImpulse(v, new Vec2(0,0));
		//}
		//Vec2 p=body.getPosition();
	}

	public void action(){}

	public void move(float x, float y) {
		Vec2 force=new Vec2(x/PIXEL2METER_RATIO/230,y/PIXEL2METER_RATIO/230);
		body.applyForce(force, body.getPosition());
		body.setLinearDamping(0.03f);
	}
}