
public class Entity {
	public int x;
	public int y;
	public int type;
	
	public static final int TYPE_WALL=0x23;
	public static final int TYPE_BOX=0x24;
	public static final int TYPE_GOAL=0x2e;
	
	public Entity(){
		
	}

	public Entity(int x,int y,int type){
		this.x=x;
		this.y=y;
		this.type=type;
	}
	
}
