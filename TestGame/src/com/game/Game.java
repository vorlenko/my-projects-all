package com.game;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.view.KeyEvent;

public class Game {

	ArrayList<Level> levels;
	
	
	transient int currentLevel=0;
	
	public void onDraw(Canvas canvas){
		    levels.get(currentLevel).onDraw(canvas);
	}

	
	transient static boolean upKeyPressed=false;
	transient static boolean downKeyPressed=false;
	transient static boolean leftKeyPressed=false;
	transient static boolean rightKeyPressed=false;
	
	
	public static void onKey(int keyCode, KeyEvent event) {

		if(event.getAction() == KeyEvent.ACTION_DOWN)
	    {
	        switch(keyCode)
	        {
	        case KeyEvent.KEYCODE_DPAD_UP:    {upKeyPressed=true;}
	        case KeyEvent.KEYCODE_DPAD_DOWN:  {downKeyPressed=true;}
	        case KeyEvent.KEYCODE_DPAD_LEFT:  {leftKeyPressed=true;}
	        case KeyEvent.KEYCODE_DPAD_RIGHT: {rightKeyPressed=true;}
	        }
	    }		
		if(event.getAction() == KeyEvent.ACTION_UP)
	    {
	        switch(keyCode)
	        {
	        case KeyEvent.KEYCODE_DPAD_UP:    {upKeyPressed=false;}
	        case KeyEvent.KEYCODE_DPAD_DOWN:  {downKeyPressed=false;}
	        case KeyEvent.KEYCODE_DPAD_LEFT:  {leftKeyPressed=false;}
	        case KeyEvent.KEYCODE_DPAD_RIGHT: {rightKeyPressed=false;}
	        }
	    }		
		
	}
}
