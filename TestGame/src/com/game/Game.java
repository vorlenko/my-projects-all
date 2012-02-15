package com.game;

import java.util.ArrayList;



import android.graphics.Canvas;
import android.util.Log;
import android.view.KeyEvent;

public class Game {

	ArrayList<Level> levels;
	
	
	transient int currentLevel=0;

	public void onStart(){
		for(Level level:levels){
			level.onStart();
		}
	}
	
	public void onDraw(Canvas canvas){

		canvas.drawARGB(255, 255, 255, 255);
		levels.get(currentLevel).onDraw(canvas);
	}

	

	public void action(float timeStep){
		
		levels.get(currentLevel).hero.move(upKeyPressed,
										   downKeyPressed,
										   leftKeyPressed,
										   rightKeyPressed);
										   
		levels.get(currentLevel).hero.move(x,y);
		
		levels.get(currentLevel).action(timeStep);
	}

	transient static float x=0;
	transient static float y=0;
	
	public static void moveAction(float x, float y) {
		Game.x=x;
		Game.y=y;
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
