package com.game;

import java.util.ArrayList;

import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import android.graphics.Canvas;

public class Level {

	ArrayList<Bound> bounds;
	
	Hero hero;
		
	transient World world;
	transient Body body;
	
	public void onStart(){
		AABB worldAABB = new AABB();  
        worldAABB.lowerBound.set(new Vec2((float) -300.0, (float) -300.0));  
        worldAABB.upperBound.set(new Vec2((float) 300.0, (float) 300.0)); 
        
		Vec2 gravity = new Vec2(0.0f, -10.0f);
		boolean doSleep = true;
		world = new World(worldAABB, gravity, doSleep);
		
	
	}

	
	public void onDraw(Canvas canvas) {
		for (Bound bound : bounds) {
		    bound.onDraw(canvas);
		}
		//Vec2 position = body.getPosition();
		//hero.x=position.x;
		//hero.y=position.y;
		
	    hero.onDraw(canvas);
	}

	public void action(float timeStep) {
		world.step(timeStep, 6);

		//hero.action();
	}
	
}
