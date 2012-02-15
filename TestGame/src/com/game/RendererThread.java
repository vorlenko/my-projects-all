package com.game;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class RendererThread  implements Runnable{
	Thread thread; 
	boolean active=false; 
	View GSV;
	Game game;
	Control control;
	Camera camera;
	
	public RendererThread(View gsv,Camera camera, Game game, Control control) {
		this.GSV=gsv;
		this.camera=camera;
		this.game=game;
		this.control=control;
	}

	private long FPS=0;
	
	private SurfaceHolder holder;
	
	public void run() {
		while(active == true){
			
			holder=GSV.holder;
			
			if(holder.getSurface().isValid()){
				Canvas canvas = null;
				try{
					canvas = holder.lockCanvas();
					synchronized(holder){
						// put frame
						camera.apply(canvas);
						game.onDraw(canvas);

						//camera.apply(canvas,0,0);
						control.onDraw(canvas);
						//camera.apply(canvas);

						FPS++;
					}
				} finally {
					if(canvas != null) holder.unlockCanvasAndPost(canvas); 
				}
			}
			

			
			// FPS
			if(previousTimeMillis==0){
				previousTimeMillis=System.currentTimeMillis();
			}else{
				long currentTimeMillis=System.currentTimeMillis();
				if(currentTimeMillis>previousTimeMillis+1000){
					previousTimeMillis=currentTimeMillis;
					Log.d("RendererThread","FPS="+FPS);
					FPS=0;
				}
			}
		}
	}

	private long previousTimeMillis=0;

	
	public void pause(){
		active = false;
		while(true){
			try{
				thread.join();
			} catch(InterruptedException e){
				Log.d("RendererThread",e.getMessage());
			}
			break;
		}
		thread = null;
	}

	public void resume(){
		thread=new Thread(this,"RendererThread");
		thread.start();
		active = true;
	}

}
