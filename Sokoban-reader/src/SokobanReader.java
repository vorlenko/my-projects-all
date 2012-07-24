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
				    		case 0x23: level.walls.add(new Wall(x,y));
				    			break;
				    		case 0x24: level.boxes.add(new Box(x,y));
				    			break;
				    		case 0x2e: level.goals.add(new Goal(x,y));
				    			break;
				    		case 0x40: level.player=new Player(x,y);
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
			out.write(gson.toJson(levels));
			out.close();
			
		}catch (Exception e){
	    	System.err.println("Error: " + e.getMessage());
	    }
	}
}
