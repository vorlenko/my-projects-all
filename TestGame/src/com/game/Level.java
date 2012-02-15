package com.game;

import java.util.ArrayList;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import android.graphics.Canvas;


public class Level {
	public static final float PIXEL2METER_RATIO = 10;


	ArrayList<Edge> edges;
	
	Hero hero;
		
	transient World world;
	
	public void onStart(){
		
		Vec2 gravity = new Vec2(0.0f, 0.0f);
		boolean doSleep = true;
		world = new World(gravity, doSleep);
		
		BodyDef bd = new BodyDef();
		bd.position.set(0.0f, 0.0f);
		Body ground = world.createBody(bd);
		
		PolygonShape shape = new PolygonShape();
		
		for(Edge edge : edges) {
			shape.setAsEdge(new Vec2(edge.x1/PIXEL2METER_RATIO, edge.y1/PIXEL2METER_RATIO), new Vec2(edge.x2/PIXEL2METER_RATIO, edge.y2/PIXEL2METER_RATIO));
			ground.createFixture(shape, 0.0f);
		}
			
        hero.onStart(world);
	}

	
	public void onDraw(Canvas canvas) {
		for (Edge edge : edges) {
		    edge.onDraw(canvas);
		}
		
	    hero.onDraw(canvas);
	}

	public void action(float timeStep) {
		world.step(timeStep, 10, 10);

		//hero.action();
	}
	
}
