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
		
	float width;
	float height;
	
	transient World world;
	
	public void onStart(){
		PolygonDef groundShapeDef;
		
		// Step 1: Create Physics World Boundaries 
		AABB worldAABB = new AABB();  
		
		Vec2 min = new Vec2(-10, -10);
		Vec2 max = new Vec2(width +10, height+10);
		
		worldAABB.lowerBound.set(min);
		worldAABB.upperBound.set(max);
		
        
        //	Step 2: Create Physics World with Gravity  
		Vec2 gravity = new Vec2(0.0f, 0.0f);
		boolean doSleep = true;
		world = new World(worldAABB, gravity, doSleep);
		
		
		//Create Ground Box :
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(new Vec2((float) 0.0, (float) -10.0));
		Body groundBody = world.createBody(bodyDef);
		groundShapeDef = new PolygonDef();
		groundShapeDef.setAsBox((float) width, (float) 10);
		groundBody.createShape(groundShapeDef);
		// up :
		bodyDef = new BodyDef();
		bodyDef.position.set(new Vec2((float) 0.0, (float) (height+10.0) ));
		groundBody = world.createBody(bodyDef);
		groundShapeDef = new PolygonDef();
		groundShapeDef.setAsBox((float) width, (float) 10);
		groundBody.createShape(groundShapeDef);
		// left :
		bodyDef = new BodyDef();
		bodyDef.position.set(new Vec2((float) -10, (float) 0.0 ));
		groundBody = world.createBody(bodyDef);
		groundShapeDef = new PolygonDef();
		groundShapeDef.setAsBox((float)10, (float) height);
		groundBody.createShape(groundShapeDef);
		// right :
		bodyDef = new BodyDef();
		bodyDef.position.set(new Vec2((float) width+10, (float) 0.0 ));
		groundBody = world.createBody(bodyDef);
		groundShapeDef = new PolygonDef();
		groundShapeDef.setAsBox((float)10, (float) height);
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
