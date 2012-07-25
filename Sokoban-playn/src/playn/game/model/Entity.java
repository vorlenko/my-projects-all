package playn.game.model;

import java.util.HashMap;

import playn.core.Image;
import playn.core.Surface;
import playn.core.SurfaceLayer;
import playn.game.core.Game;


public class Entity implements Comparable<Entity> {
	public int x;
	public int y;
	public int type;
	
	public static final String FILE_WALL="wall.png";
	public static final String FILE_BOX ="box.png";
	public static final String FILE_GOAL="goal.png";
	public static final String FILE_FLOOR="floor.png";
	public static final String FILE_PLAYER="player.png";

	public static final int TYPE_WALL=0x23;
	public static final int TYPE_BOX=0x24;
	public static final int TYPE_GOAL=0x2e;
	public static final int TYPE_FLOOR=0;
	public static final int TYPE_PLAYER=0x40;
	public static final int TYPE_EMPTY=-1;
	
	private static HashMap<Integer,String> resources = new HashMap<Integer, String>(){
		private static final long serialVersionUID = 1L;
		{
			put(TYPE_WALL, FILE_WALL);
			put(TYPE_BOX,  FILE_BOX);
			put(TYPE_GOAL, FILE_GOAL);
			put(TYPE_FLOOR, FILE_FLOOR);
			put(TYPE_PLAYER, FILE_PLAYER);
			put(TYPE_EMPTY, null);
		}
	};

	
	public Entity(){
		
	}

	public Entity(int x,int y,int type){
		this.x=x;
		this.y=y;
		this.type=type;
	}

	public void paint(SurfaceLayer layer) {
    	Image image=null;
        
    	String name=resources.get(type);
    	
    	
    	
    	if(name!=null){
    		if(!Game.images.containsKey(name)){
    			System.out.println("you have to load "+name+" image from loader using imagesCache");
    		} else {
                image=Game.images.get(name);
    		}
    	
        Surface surface = layer.surface();
        surface.drawImage(image, x*32,y*32);
    	}
		
	}

	@Override
	public int compareTo(Entity o) {
		int w1=x+y;
		int w2=o.x+o.y;

		
		
		if(w1<w2) {return 1;}
		else if(w1>w2){return -1;}
		
			if((o.type==TYPE_PLAYER)&&(type==TYPE_GOAL)){
				return 1;
			}

			if((o.type==TYPE_BOX)&&(type==TYPE_GOAL)){
				return 1;
			}

			if((type==TYPE_BOX)&&(o.type==TYPE_FLOOR)){
				return -1;
			}

		//}
		return -1;
	}

	
}
