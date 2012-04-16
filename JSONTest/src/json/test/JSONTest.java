package json.test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JSONTest {

	public static void main(String[] args){
		
		GsonBuilder GB = new GsonBuilder();
		
		//GB.
        //GB.registerTypeAdapter(Type1.class, new Type1());
        //GB.registerTypeAdapter(Type2.class, new Type2());
		
		
		//http://massapi.com/class/gs/GsonBuilder.html
        Gson gson = GB.create(); 
        		
        
        
        //http://code.google.com/p/google-gson/source/browse/trunk/extras/src/main/java/com/google/gson/extras/examples/rawcollections/RawCollectionsExample.java
        
        
        
        
        Container c = new Container();

        try {
			BufferedReader br = new BufferedReader(new FileReader("C:/1.json"));
			c=  gson.fromJson(br,Container.class);
    	} catch (IOException e) {
			System.out.println(e.getMessage());
		}

        
		System.out.println(gson.toJson(c));
		
		//c.out();
        
	}

}
