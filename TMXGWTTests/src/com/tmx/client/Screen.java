package com.tmx.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;


public class Screen {
	private Canvas canvas;
	
	public Screen(){
		canvas = null;
		canvas=Canvas.createIfSupported();
		canvas.setStyleName("mainCanvas");
	
	}

	public Canvas getCanvas(){
		return(canvas);
	}
	
	public int getHeight() {
		return canvas.getCoordinateSpaceHeight();
	}

	public int getWidth() {
		return canvas.getCoordinateSpaceWidth();
	}

	public void clear(){
		rectangle(0,0, width, height, new Color(0,0,0)); 
	}
	
	public void rectangle(int x, int y, int width, int height, Color color) {
		Context2d context = canvas.getContext2d();
        CssColor c = CssColor.make("rgba(" + color.getRed() + ", " + color.getGreen() + "," + color.getBlue() + ", 255)");
        context.setFillStyle(c);
        context.fillRect(x,y,width,height);
        context.fill();
	}

	public void line(int x1, int y1, int x2, int y2, Color color) {
		Context2d context = canvas.getContext2d();
        CssColor c = CssColor.make("rgba(" + color.getRed() + ", " + color.getGreen() + "," + color.getBlue() + ", 255)");
        context.setStrokeStyle(c);
        context.setLineCap("square");
        context.setLineWidth(1);
        context.setLineJoin("bevel");
        context.beginPath();
        context.moveTo(x1, y1);
        context.lineTo(x2, y2);
        context.stroke();
	}

	public void circle(int x, int y, int radius, Color color) {
		Context2d context = canvas.getContext2d();
        CssColor c = CssColor.make("rgba(" + color.getRed() + ", " + color.getGreen() + "," + color.getBlue() + ", 255)");
        context.setStrokeStyle(c);
        context.beginPath();
        context.arc(x, y, radius, 0, Math.PI * 2.0);
        context.closePath();
        context.stroke();
	}

	private int width;
	private int height;
	
	public void resize(int width, int height) {
		this.width=width;
		this.height=height;
        canvas.setWidth(width + "px");
        canvas.setCoordinateSpaceWidth(width);
        canvas.setHeight(height + "px");
        canvas.setCoordinateSpaceHeight(height);
        canvas.setPixelSize(width, height);
	}

	public void putImage(Image img, int sx, int sy, int sw, int sh, int dx,int  dy,int  dw,int  dh) {
		ImageElement imageElement = ImageElement.as(img.getElement());
		Context2d context = canvas.getContext2d();
		context.drawImage(imageElement, sx, sy, sw, sh, dx, dy, dw, dh);
	}

}
