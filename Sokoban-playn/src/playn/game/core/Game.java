package playn.game.core;

import java.util.ArrayList;
import java.util.HashMap;

import playn.core.Image;
import playn.game.model.Level;

import static playn.core.PlayN.*;


public class Game implements playn.core.Game {
	
	public static int SCREEN_WIDTH=640;
	public static int SCREEN_HEIGHT=480;
	public static boolean initialized=false;
	public static final float PIXEL_PER_METER=500;

	public static HashMap<String, Image> images;
	public static ArrayList<Level> levels;
	
	public static Controls controls;
	
	public Game(Controls controls,ArrayList<Level> levels,HashMap<String, Image> images) {
		this.levels=levels;
		this.images=images;
		this.controls=controls;
	}

	
	public void init() {
		graphics().rootLayer().setScale(1,1);
		
		keyboard().setListener(controls);
	}

	
	public void update(float delta) {
	}

	public void paint(float alpha) {
	}

	public int updateRate() {
		return 15;
	}
	
}
