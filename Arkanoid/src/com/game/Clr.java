package com.game;

public class Clr {
	float r=0;
	float g=0;
	float b=0;
	
	public void setHSV(float angle){
		
		
		float r1=2-Math.abs(angle-0)/60;
		float r2=2-Math.abs(angle-360)/60;
		
		
		g=2-Math.abs(angle-120)/60;
		b=2-Math.abs(angle-240)/60;

		
		
		r=Math.max(r1, r2);
		r=Math.max(r, 0);
		r=Math.min(r, 1);
		g=Math.max(g, 0);
		g=Math.min(g, 1);
		b=Math.max(b, 0);
		b=Math.min(b, 1);
	}
}
