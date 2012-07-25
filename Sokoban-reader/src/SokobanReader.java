import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;


public class SokobanReader {
	public static void main(String args[]){
		try{
			FileInputStream fstream = new FileInputStream("level5.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine;

			String name="";
	  
			ArrayList<Level> levels=new ArrayList<Level>();
	  
			Level level = null;
			int y=0;
	  
			while ((strLine = br.readLine()) != null)   {
	  
				if(strLine.contains(";")){
			  
					if(level!=null){
						levels.add(level);
					}
			  
					name=strLine.replace(";", "");
					level=new Level(name);
					y=0;
				}
		  
		  
				if(strLine.contains("#")){
			  
					char[] ch = strLine.toCharArray();
				
					int x=0;
			  
					for (char c : ch){
						Character symbol=new Character(c);
				  
						switch(symbol){
			    			case Entity.TYPE_BOX: level.items.add(new Entity(x,y,Entity.TYPE_BOX));
			    				break;
			    			case Entity.TYPE_WALL: level.items.add(new Entity(x,y,Entity.TYPE_WALL));
			    				break;
			    			case Entity.TYPE_GOAL: level.items.add(new Entity(x,y,Entity.TYPE_GOAL));
			    				break;
				    		default:
				    			break;
						}
						x++;
		  	  		}
					y++;
				}
			}
	  
			Gson gson=new Gson();

			BufferedWriter out = new BufferedWriter(new FileWriter("levels.json"));
			
			LevelsContainer container=new LevelsContainer(levels);
			
			out.write(gson.toJson(container));
			out.close();
			
		}catch (Exception e){
	    	System.err.println("Error: " + e.getMessage());
	    }
	}
}
