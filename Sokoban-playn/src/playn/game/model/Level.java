package playn.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import playn.core.GroupLayer;
import playn.core.ImmediateLayer;
import playn.core.Surface;
import playn.game.core.Game;
import static playn.core.PlayN.graphics;


public class Level implements ImmediateLayer.Renderer {
        
        public String name;
        public ArrayList<Entity> items=new ArrayList<Entity>();
        
        private int width=0;
        private int height=0;
        
        Level(){
        }

        Level(String name){
                this.name=name;
        }
        
        public static GroupLayer layer;
        
        ImmediateLayer sceneLayer;

        
        public void init(){
        	
                layer=graphics().createGroupLayer();
                
                calc();
                
                backup();
                
                sceneLayer=graphics().createImmediateLayer((width+1)*32,(height+1)*32,this);
                
                layer.addAt(sceneLayer,(Game.SCREEN_WIDTH-(width+1)*32)/2,(Game.SCREEN_HEIGHT-(height+1)*32)/2);
        }

        
        public void backup() {
        	for(Entity item:items){
        		item.backup();
        	}
        }
        
        public void restore() {
        	for(Entity item:items){
        		item.restore();
        	}
		}
        
        Comparator<Entity> comparator=new Comparator<Entity>(){
				@Override
				public int compare(Entity a, Entity b) {
					return b.compareTo(a);
				}
			};
        
        
        public Entity entityExist(int x,int y,int type){
            for(Entity e:items){
            	if((e.x==x)&&(e.y==y)&&(e.type==type)){return e;}
            }
        	return null;
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
            		if((entityExist(x,y,Entity.TYPE_FLOOR)==null)&&
               		   (entityExist(x,y,Entity.TYPE_WALL)==null)&&
               		   (entityExist(x,y,Entity.TYPE_GOAL)==null)
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
        
        private Entity getPlayer(){
        	
            for(Entity e:items){
            	if(e.type==Entity.TYPE_PLAYER){return e;}
            }

        	return null;
        }

		public void left() {
			boolean flag=true;
			Entity player=getPlayer();
			if(entityExist(player.x-1,player.y,Entity.TYPE_WALL)==null){
				Entity box=entityExist(player.x-1,player.y,Entity.TYPE_BOX);
				if(box!=null){
					if((entityExist(player.x-2,player.y,Entity.TYPE_WALL)==null)&&(entityExist(player.x-2,player.y,Entity.TYPE_BOX)==null)){
						box.left();
					} else flag=false;
				}
				if (flag) player.left();
			}
		}

		public void up() {
			boolean flag=true;
			Entity player=getPlayer();
			if(entityExist(player.x,player.y-1,Entity.TYPE_WALL)==null){
				Entity box=entityExist(player.x,player.y-1,Entity.TYPE_BOX);
				if(box!=null){
					if((entityExist(player.x,player.y-2,Entity.TYPE_WALL)==null)&&(entityExist(player.x,player.y-2,Entity.TYPE_BOX)==null)){
						box.up();
					} else flag=false;
				}
				if (flag) player.up();
			}
		}

		public void right() {
			boolean flag=true;
			Entity player=getPlayer();
			if(entityExist(player.x+1,player.y,Entity.TYPE_WALL)==null){
				Entity box=entityExist(player.x+1,player.y,Entity.TYPE_BOX);
				if(box!=null){
					if((entityExist(player.x+2,player.y,Entity.TYPE_WALL)==null)&&(entityExist(player.x+2,player.y,Entity.TYPE_BOX)==null)){
						box.right();
					} else flag=false;
				}
				if (flag) player.right();
			}
		}

		public void down() {
			boolean flag=true;
			Entity player=getPlayer();
			if(entityExist(player.x,player.y+1,Entity.TYPE_WALL)==null){
				Entity box=entityExist(player.x,player.y+1,Entity.TYPE_BOX);
				if(box!=null){
					if((entityExist(player.x,player.y+2,Entity.TYPE_WALL)==null)&&(entityExist(player.x,player.y+2,Entity.TYPE_BOX)==null)){
						box.down();
					} else flag=false;
				}
				if (flag) player.down();
			}
		}

		@Override
		public void render(Surface surface) {
			
            Collections.sort(items,new Comparator<Entity>(){
				@Override
				public int compare(Entity a, Entity b) {
					return b.compareTo(a);
				}});

			
            for(Entity entity:items){
            	entity.paint(surface);
            }
		}
}