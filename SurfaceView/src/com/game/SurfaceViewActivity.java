package com.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceViewActivity extends Activity {
    
	OurView v;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new OurView(this);
        setContentView(v);
    }


    @Override
	protected void onPause() {
		super.onPause();
		v.pause();
	}


	@Override
	protected void onResume() {
		super.onResume();
		v.resume();
	}


	public class OurView extends SurfaceView implements Runnable{

		Thread t = null;
		SurfaceHolder holder;
		boolean isItOK=false;
		
		public OurView(Context context) {
			super(context);
			holder = getHolder();
		}

		@Override
		public void run() {
			while(isItOK == true){
				// perform canvas drawing
				if(!holder.getSurface().isValid()){
					continue;
				}
				Canvas c = holder.lockCanvas();
				c.drawARGB(255, (int) (255*Math.random()), 150, 10);
				holder.unlockCanvasAndPost(c);
			}
		}
		
		public void pause(){
			isItOK = false;
			while(true){
				try{
					t.join();
				} catch(InterruptedException e){
					Log.d("thread",e.getMessage());
				}
				break;
			}
			t = null;
		}
		
		public void resume(){
			isItOK = true;
			t = new Thread(this);
			t.start();
		}
    	
    }
}