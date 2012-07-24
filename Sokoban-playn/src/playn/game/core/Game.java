package playn.game.core;

import java.util.ArrayList;
import java.util.HashMap;

import playn.core.Image;
import playn.game.model.Level;

import static playn.core.PlayN.*;


public class Game implements playn.core.Game {
	public static final String WALL_FILE="block.png";

	public static int SCREEN_WIDTH=640;
	public static int SCREEN_HEIGHT=480;
	public static boolean initialized=false;
	public static final float PIXEL_PER_METER=500;

	public static HashMap<String, Image> images;
	public ArrayList<Level> levels;
	
	public Controls controls;
	
	public Game(Controls controls,ArrayList<Level> levels,HashMap<String, Image> images) {
		this.levels=levels;
		this.images=images;
		this.controls=controls;
	}

	
	public void init() {
		graphics().rootLayer().setScale(1,1);
		
		keyboard().setListener(controls);
		
		Level level=levels.get(0);
		level.init();
		
		graphics().rootLayer().add(level.layer);
		
	}

	
	public void update(float delta) {
	}

	public void paint(float alpha) {
	}

	public int updateRate() {
		return 15;
	}
	
}
