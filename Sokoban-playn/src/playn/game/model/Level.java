package playn.game.model;

import java.util.ArrayList;

import playn.core.GroupLayer;
import playn.core.SurfaceLayer;
import static playn.core.PlayN.graphics;


public class Level {
        
        public String name;
        public ArrayList<Entity> items=new ArrayList<Entity>();
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
                
                
                for(Entity entity:items){
                	entity.paint(background);
                }                	

                
        }
        
}