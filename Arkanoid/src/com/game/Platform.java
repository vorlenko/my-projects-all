package com.game;

import com.badlogic.gdx.graphics.Pixmap;

public class Platform {
	
	int x;
	
	int width;
	int height;
	public Platform(int width, int height){
		this.width=width;
		this.height=height;
		x=0;
	}
	
	
	final private int PLATFORM_WIDTH=50;
	final private int PLATFORM_HEIGHT=10;
	
	
	public void onDraw(Pixmap pixmap){
		
		pixmap.setColor(1.0f,1.0f,1.0f, 1.0f);
		pixmap.drawRectangle(width/2+x-PLATFORM_WIDTH/2, height-PLATFORM_HEIGHT-20, PLATFORM_WIDTH, PLATFORM_HEIGHT);
		
	}


	public void setX(int x) {
		this.x=x;
	}
}
