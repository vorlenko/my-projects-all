package com.tmx;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Loader {
	static Image img;
	
	public static void main(String[] args) throws IOException{
		
		img = ImageIO.read(new File("assets/desert_tiled.png" ));
		 
		
		JFrame frm = new JFrame("TMX Example");
		
		frm.addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent event) {
		        System.exit (0);
		    }
		});
		
		frm.getContentPane().add(new Canvas(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g)
		    {
				g.drawImage(img, 300, 300, 364, 364, 0, 0, 64, 64, this);
		    }
			
			
		}); 
		
		frm.setSize(400,400);
		frm.setVisible(true);
	}
		
}
