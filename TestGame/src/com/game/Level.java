package com.game;

import java.util.ArrayList;

import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;

import org.jbox2d.dynamics.World;

import android.graphics.Canvas;

public class Level {

	ArrayList<Bound> bounds;
	
	Hero hero;
		
	float width;
	float height;
	
	transient World world;
	
	public void onStart(){
		
		// Step 1: Create Physics World Boundaries 
		AABB worldAABB = new AABB();  
		
		Vec2 min = new Vec2(-100, -100);
		Vec2 max = new Vec2(+100, +100);
		
		worldAABB.lowerBound.set(min);
		worldAABB.upperBound.set(max);
		
        
        //	Step 2: Create Physics World with Gravity  
		Vec2 gravity = new Vec2(0.0f, 0.0f);
		boolean doSleep = true;
		world = new World(gravity, doSleep);
		
		
			
		// Step 4: Create dynamic body  
        hero.onStart(world);
	}

	
	public void onDraw(Canvas canvas) {
		for (Bound bound : bounds) {
		    bound.onDraw(canvas);
		}
		
	    hero.onDraw(canvas);
	}

	public void action(float timeStep) {
		world.step(timeStep, 6, 2);

		//hero.action();
	}
	
}
