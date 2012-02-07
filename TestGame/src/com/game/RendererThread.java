package com.game;

import android.graphics.Canvas;
import android.util.Log;

public class RendererThread  implements Runnable{
	Thread thread; 
	boolean active=false; 
	View GSV;
	
	
	public RendererThread(View gsv) {
		this.GSV=gsv;
	}

	public RendererThread(){
		Log.d("RendererThread","Cunstructor call must be with GameSurfaceView parameter!");
	}



	private long FPS=0;
	
	@Override
	public void run() {
		while(active == true){
			
			if(GSV.holder.getSurface().isValid()){

				
				// put frame
				Canvas c = GSV.holder.lockCanvas();
				c.drawARGB(255, (int) (255*Math.random()), 150, 10);
				GSV.holder.unlockCanvasAndPost(c);
				
				FPS++;
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
