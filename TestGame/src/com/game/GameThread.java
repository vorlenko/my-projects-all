package com.game;


import android.util.Log;

public class GameThread implements Runnable{
	Thread thread; 
	boolean active=false; 
	Game game;
	
	public GameThread(Game game, Camera camera) {
		this.game=game;
		
		game.onStart(camera);
	}

	public void run() {
		while(active == true){
			
		
			// game action every 10 milliseconds =)
			if(previousTimeMillis==0){
				previousTimeMillis=System.currentTimeMillis();
			}else{
				long currentTimeMillis=System.currentTimeMillis();
				if(currentTimeMillis>previousTimeMillis+10){
					game.action(currentTimeMillis-previousTimeMillis);
					previousTimeMillis=currentTimeMillis;
				}
			}
			
			
			
			
		}
	}

	/*
	private long getDeltaTime(){
		if(previousTimeMillis==0){
			previousTimeMillis=System.currentTimeMillis();
			return 0;
		}
		long currentTimeMillis=System.currentTimeMillis();
		long deltaTime=currentTimeMillis-previousTimeMillis;
		return(deltaTime);
	}
	*/
	private long previousTimeMillis=0;

	
	public void pause(){
		active = false;
		while(true){
			try{
				thread.join();
			} catch(InterruptedException e){
				Log.d("GameThread",e.getMessage());
			}
			break;
		}
		thread = null;
	}
	
	public void resume(){
		thread=new Thread(this,"GameThread");
		thread.start();
		active = true;
	}

}
