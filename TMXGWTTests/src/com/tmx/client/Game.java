package com.tmx.client;





import tiled.core.Map;

import com.google.gwt.user.client.ui.Image;




public class Game {
	
	public Image img;
	
	public Game(Map map) {
		img = new Image("desert_tiled.png");
	}
	
	public void resize(int width, int height) {}

	float a=0;
	
	public void render(Screen screen,int refreshRate) {
		screen.clear();
		
		a=a+0.1f;
		
		for(int x=0;x<30;x++){
			for(int y=0;y<30;y++){
				screen.putImage(img,32,32,32,32,x*32,y*32,32,32);
			}
		}
		screen.circle((int)(512+100*Math.sin(a)), (int)(512+100*Math.cos(a)), 100, new Color(255,255,255));
		
		//for(int x=1;x<100;x++){
		//}
	
    }




}
