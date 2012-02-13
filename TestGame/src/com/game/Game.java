package com.game;

import java.util.ArrayList;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

import android.graphics.Canvas;
//import android.util.Log;
import android.view.KeyEvent;

public class Game {

	ArrayList<Level> levels;
	
	
	transient int currentLevel=0;

	World world;
	public void onStart(){
		Vec2 gravity = new Vec2(0.0f, -10.0f);
		boolean doSleep = true;
		world = new World(gravity, doSleep);
		/*
		
		final Shape ground = new Rectangle(0, CAMERA_HEIGHT - 2, CAMERA_WIDTH, 2);
        final Shape roof = new Rectangle(0, 0, CAMERA_WIDTH, 2);
        final Shape left = new Rectangle(0, 0, 2, CAMERA_HEIGHT);
        final Shape right = new Rectangle(CAMERA_WIDTH - 2, 0, 2, CAMERA_HEIGHT);
        final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(0, 0.5f, 0.5f);
        
        PhysicsFactory.createBoxBody(this, ground, BodyType.STATIC, wallFixtureDef);
        PhysicsFactory.createBoxBody(this, roof, BodyType.STATIC, wallFixtureDef);
        PhysicsFactory.createBoxBody(this, left, BodyType.STATIC, wallFixtureDef);
        PhysicsFactory.createBoxBody(this, right, BodyType.STATIC, wallFixtureDef);
        */
	}
	
	public void onDraw(Canvas canvas){

		canvas.drawARGB(255, 0, 0, 0);
		levels.get(currentLevel).onDraw(canvas);
	}

	

	public void action(float timeStep){
		world.step(timeStep, 6, 2);
		
		levels.get(currentLevel).hero.move(upKeyPressed,
										   downKeyPressed,
										   leftKeyPressed,
										   rightKeyPressed);
		levels.get(currentLevel).action();
	}

	
	transient static boolean upKeyPressed=false;
	transient static boolean downKeyPressed=false;
	transient static boolean leftKeyPressed=false;
	transient static boolean rightKeyPressed=false;
	
	public static void onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode)
        {
        case KeyEvent.KEYCODE_DPAD_UP:    upKeyPressed=true;    return;
        case KeyEvent.KEYCODE_DPAD_DOWN:  downKeyPressed=true;  return;
        case KeyEvent.KEYCODE_DPAD_LEFT:  leftKeyPressed=true;  return;
        case KeyEvent.KEYCODE_DPAD_RIGHT: rightKeyPressed=true; return;
        }
	}
	
	public static void onKeyUp(int keyCode, KeyEvent event) {
        switch(keyCode)
        {
        case KeyEvent.KEYCODE_DPAD_UP:    upKeyPressed=false;    return;
        case KeyEvent.KEYCODE_DPAD_DOWN:  downKeyPressed=false;  return;
        case KeyEvent.KEYCODE_DPAD_LEFT:  leftKeyPressed=false;  return;
        case KeyEvent.KEYCODE_DPAD_RIGHT: rightKeyPressed=false; return;
        }
	}
}
