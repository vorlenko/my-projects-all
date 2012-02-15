package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	Game game = new Game();
	GameThread GT;
	RendererThread RT;
	View GSV;
	Control control;
	Camera camera=new Camera();
	boolean initialized=false;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("gamedata.json")));
			game = gson.fromJson(br,Game.class);
			Log.d("JSON","loaded game data:"+gson.toJson(game));
    	} catch (IOException e) {
			Log.d("JSON",e.getMessage());
		}
		
        GSV=new View(this);
        control=new Control(GSV);
        
        GT=new GameThread(game,camera);
        RT=new RendererThread(GSV,camera, game, control);
        setContentView(GSV);
        initialized=true;
    }

	
	protected void onPause() {
		super.onPause();
		GT.pause();
		RT.pause();
	}
	
	
	protected void onResume() {
		super.onResume();
		GT.resume();
		RT.resume();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(initialized) Game.onKeyDown(keyCode, event);
		return super.onKeyDown(keyCode, event);
	}

	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if(initialized) Game.onKeyUp(keyCode, event);
		return super.onKeyUp(keyCode, event);
	}
	
	@Override
	  public boolean onTouchEvent(MotionEvent event) {
		if(initialized) {
			control.onTouchEvent(event);
			Game.moveAction(control.x,control.y);
		}
		return true;
	}
	
}