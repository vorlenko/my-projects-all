package com.tmx.client;

public class Color{
	int r;
	int g;
	int b;
	
	public Color(int r,int g,int b){
		this.r=r;
		this.g=g;
		this.b=b;
	}

	public Color(float r, float g, float b) {
		this.r=(int) (r*255);
		this.g=(int) (g*255);
		this.b=(int) (b*255);
	}

	public int getRed() {
		return r;
	}

	public int getGreen() {
		return g;
	}

	public int getBlue() {
		return b;
	}
	
	public void set(int r,int g,int b){
		this.r=r;
		this.g=g;
		this.b=b;
	}
	
}
