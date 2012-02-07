package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	Game game;
	GameThread GT;
	RendererThread RT;
	View GSV;
	
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
        GT=new GameThread();
        RT=new RendererThread(GSV, game);
        setContentView(GSV);
    }

	
	@Override
	protected void onPause() {
		super.onPause();
		GT.pause();
		RT.pause();
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		GT.resume();
		RT.resume();
	}

	
}