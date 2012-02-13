package com.game;

import java.util.ArrayList;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.CircleDef;
import org.jbox2d.collision.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import android.graphics.Canvas;
import android.util.Log;

public class Level {

	ArrayList<Bound> bounds;
	
	Hero hero;
		
	transient World world;
	
	public void onStart(){
		// Step 1: Create Physics World Boundaries 
		AABB worldAABB = new AABB();  
        worldAABB.lowerBound.set(new Vec2((float) -300.0, (float) -300.0));  
        worldAABB.upperBound.set(new Vec2((float) 300.0, (float) 300.0)); 
        
        //	Step 2: Create Physics World with Gravity  
		Vec2 gravity = new Vec2(0.0f, 0.0f);
		boolean doSleep = true;
		world = new World(worldAABB, gravity, doSleep);
		
		
		// Step 3: Create Ground Box  
		BodyDef groundBodyDef = new BodyDef(); 
        groundBodyDef.position.set(new Vec2((float) 10.0, (float) 10.0));  
        Body groundBody = world.createBody(groundBodyDef);  
        PolygonDef groundShapeDef = new PolygonDef();  
        groundShapeDef.setAsBox((float) 150.0, (float) 150.0);  
        groundBody.createShape(groundShapeDef);
        
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
		world.step(timeStep, 6);

		//hero.action();
	}
	
}
