import java.util.ArrayList;


public class Level {
	public String name;
	public ArrayList<Wall> walls=new ArrayList<Wall>();
	public ArrayList<Box> boxes=new ArrayList<Box>();
	public ArrayList<Goal> goals=new ArrayList<Goal>();
	public Player player;
	
	Level(String name){
		this.name=name;
	}
}
