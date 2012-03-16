package com.game;

import com.badlogic.gdx.graphics.Pixmap;

public class Background {

	private static int NUMBER_OF_POINTS=50000;
	
	Point3d[] points= new Point3d[NUMBER_OF_POINTS];
	
	
	int width=0;
	int height=0;
	
	public Background(int width, int height){
		this.width=width;
		this.height=height;
		
		int x=0;
		int y=0;
		int z=0;
		
		for(int i=0;i<NUMBER_OF_POINTS;i++){
			x=(int) (Math.random()*width-width/2);
			y=(int) (Math.random()*height-height/2);
			z=(int) (Math.random()*100);

			points[i] = new Point3d(x,y,z);
		}
	}
	
	public void onDraw(Pixmap pixmap){
		float x=0;
		float y=0;
		float z=0;
		int x2d=0;
		int y2d=0;
		float c=0;
		final float z1=0;
		final float z2=100;
		
		for(int i=0;i<NUMBER_OF_POINTS;i++){
			x=points[i].x;
			y=points[i].y;
			z=points[i].z;
			
			x2d = (int) ((x+2)*(z1 - z2) / (z1 - z)) + width/2;
			y2d = (int) ((y+2)*(z1 - z2) / (z1 - z)) + height/2;
			
			c=1-z/100;
			pixmap.setColor(c,c,c, 1.0f);
			
			pixmap.drawPixel(x2d,y2d);
		}
	}
	
	public void onUpdate(int msecs){
		int z=0;

		for(int i=0;i<NUMBER_OF_POINTS;i++){
			z=points[i].z;
			z=z-msecs;
			if(z<0){z=z+100;}
			points[i].z=z;
		}
	}
	
}
