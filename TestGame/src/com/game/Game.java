package com.game;

import java.util.ArrayList;



import android.graphics.Canvas;
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

		canvas.drawARGB(255, 0, 0, 0);
		levels.get(currentLevel).onDraw(canvas);
	}

	

	public void action(float timeStep){
		
		levels.get(currentLevel).hero.move(upKeyPressed,
										   downKeyPressed,
										   leftKeyPressed,
										   rightKeyPressed);
		levels.get(currentLevel).action(timeStep);
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
