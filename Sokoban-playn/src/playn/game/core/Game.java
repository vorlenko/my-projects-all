package playn.game.core;

import java.util.ArrayList;
import java.util.HashMap;
import playn.core.Image;
import playn.core.PlayN;
import playn.game.model.Level;
import static playn.core.PlayN.*;


public class Game implements playn.core.Game {
	
	private static final String STORAGEKEY_N="N";
	
	public static int SCREEN_WIDTH=640;
	public static int SCREEN_HEIGHT=480;

	public static HashMap<String, Image> images;
	public static ArrayList<Level> levels;
	
	public Controls controls;
	
	public Game(Controls controls,ArrayList<Level> levels,HashMap<String, Image> images) {
		this.levels=levels;
		this.images=images;
		this.controls=controls;
	}

	public static Level level;
	
	public void init() {

		graphics().rootLayer().setScale(1f,1f);
		
		keyboard().setListener(controls);
		
		for(Level level:levels){
			level.calc();
			level.backup();
			
		}
		
		String levelNumber=PlayN.storage().getItem(STORAGEKEY_N);
		
		if(levelNumber!=null){
			n=Integer.parseInt(levelNumber);
			
		}
		
		System.out.println("current level="+n);
		
		switchToLevel(n);
		
		
		
	}

	private static void switchToLevel(int num){
		n=num;
		level=levels.get(n);
		level.init();
		
		graphics().rootLayer().clear();
		graphics().rootLayer().add(level.layer);
		
		System.out.println("level:"+n);
	}
	
	
	public void update(float delta) {
		
	}

	public void paint(float alpha) {
	}

	public int updateRate() {
		return 15;
	}

	private static int n=0;

	public static void prevoiusLevel() {
		System.out.println("previousLevel");
		if(n>0) {
			n--;
			switchToLevel(n);
		}
	}


	public static void nextLevel() {
		System.out.println("nextLevel");
		if(n<levels.size()-1) {
			n++;
			switchToLevel(n);
		}
	}

	public static void saveAndExit() {
		System.out.println("save n="+n);
		
		int i=0;
		for(Level level:levels){
			String trace=level.getTrace();
			
			if(!trace.equals("")){
				System.out.println(i+":"+trace);
			}
			i++;
		}
				
		PlayN.storage().setItem(STORAGEKEY_N, String.valueOf(n));
	}

	public static void back() {
		level.back();
	}
	
}
