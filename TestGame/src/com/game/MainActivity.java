package com.game;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	GameThread GT;
	RendererThread RT;
	View GSV;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        GSV=new View(this);
        GT=new GameThread();
        RT=new RendererThread(GSV);
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