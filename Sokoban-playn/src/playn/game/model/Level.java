package playn.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import playn.core.GroupLayer;
import playn.core.SurfaceLayer;
import static playn.core.PlayN.graphics;


public class Level {
        
        public String name;
        public ArrayList<Entity> items=new ArrayList<Entity>();
        public Player player;
        
        private int width=0;
        private int height=0;
        
        Level(){
        }

        Level(String name){
                this.name=name;
        }
        
        public static GroupLayer layer;
        
        public static SurfaceLayer background;
        
        public void init(){
                layer=graphics().createGroupLayer();
                
                
                calc();
                
                Collections.sort(items,new Comparator<Entity>(){
					@Override
					public int compare(Entity a, Entity b) {
						return b.compareTo(a);
					}});

                background=graphics().createSurfaceLayer((width+1)*32, (height+1)*32);
                
                layer.addAt(background,(640-(width+1)*32)/2,(480-(height+1)*32)/2);

                for(Entity entity:items){
                	entity.paint(background);
                }
                
                
                

        }
        
        private boolean entityExist(int x,int y,int type){
        	boolean flag=false;
            for(Entity e:items){
            	if((e.x==x)&&(e.y==y)&&(e.type==type)){flag=true;}
            }
        	return flag;
        }
        
        
        private Entity getEntityFrom(int x,int y){
        	Entity entity=null;
            for(Entity e:items){
            	if((e.x==x)&&(e.y==y)){entity=e;}
            }
            return entity;
        }
        
        private void calc(){
        	
        	// get width, height
            for(Entity entity:items){
            	if(entity.x>width){width=entity.x;};
            	if(entity.y>height){height=entity.y;};
            }
            width++;
            height++;

        	//calc floors
        	for(int x=0;x<width;x++)
            	for(int y=0;y<height;y++)
            		if((!entityExist(x,y,Entity.TYPE_FLOOR))&&
               		   (!entityExist(x,y,Entity.TYPE_WALL))&&
               		   (!entityExist(x,y,Entity.TYPE_GOAL))
            		   ){
            			items.add(new Entity(x,y,Entity.TYPE_FLOOR));
            			
            		}
            		
        	//clear not used floors
        	for(int i=0;i<width*height/2;i++){
        		//int index=0;
                for(Entity e:items){
                	if(e.type==Entity.TYPE_FLOOR){
                		Entity eL=getEntityFrom(e.x-1,e.y);
                		Entity eR=getEntityFrom(e.x+1,e.y);
                		Entity eU=getEntityFrom(e.x,e.y-1);
                		Entity eD=getEntityFrom(e.x,e.y+1);
                		
                		if(((eL==null)||(eL.type==Entity.TYPE_EMPTY)) ||
                		   ((eR==null)||(eR.type==Entity.TYPE_EMPTY)) ||
                		   ((eU==null)||(eU.type==Entity.TYPE_EMPTY)) ||
                		   ((eD==null)||(eD.type==Entity.TYPE_EMPTY)) 
                		  ){
                    		e.type=Entity.TYPE_EMPTY;
                		}
                	}
                }
        	}
        }
}