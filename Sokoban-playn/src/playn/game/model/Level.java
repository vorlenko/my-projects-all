package playn.game.model;
import java.util.ArrayList;

import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.Surface;
import playn.core.SurfaceLayer;
import playn.game.core.Game;
import static playn.core.PlayN.graphics;


public class Level {
	
	public String name;
	public ArrayList<Wall> walls=new ArrayList<Wall>();
	public ArrayList<Box> boxes=new ArrayList<Box>();
	public ArrayList<Goal> goals=new ArrayList<Goal>();
	public Player player;
	
	Level(){
	}

	Level(String name){
		this.name=name;
	}
	
	public static GroupLayer layer;
	
	public static SurfaceLayer background;
	
	public void init(){
		layer=graphics().createGroupLayer();
		
		background=graphics().createSurfaceLayer(640, 480);
		
		layer.add(background);
		
		
		for(Wall wall:walls){
			Image image=null;
			
			if(!Game.images.containsKey(Game.WALL_FILE)){
				System.out.println("you have to load "+Game.WALL_FILE+" image from loader using imagesCache");
			} else {
				image=Game.images.get(Game.WALL_FILE);
			}

			Surface surface = background.surface();
			surface.drawImage(image, wall.x*32,wall.y*32);
		}
		
	}
}
