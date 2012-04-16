package json.test;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JSONTest {

	public static String fromArray2JSON(ArrayList<Object> objects,String pkg){
		String result = "";
		Gson g = new Gson();
		
		Iterator<Object> i=objects.iterator();
		while (i.hasNext()) {
			
			Object obj=i.next();
		
			String name=obj.getClass().toString();

			
			String value=g.toJson(obj);
			
			result+="'"+name+"':{"+value+"}";
			
			//System.out.println("class="+obj.getClass());
		}
		
		
		
		return(result);
	}
	
	public static ArrayList<Object> fromJSON2Array(String data,String pkg){
		ArrayList<Object> result = new ArrayList<Object>();
		Gson g = new Gson();
	    JsonParser parser = new JsonParser();
	    JsonArray array = parser.parse(data).getAsJsonArray();
	    
	    Iterator <JsonElement> i=array.iterator();
	    
	    while (i.hasNext() ){
	    	JsonElement je=i.next();
	    	JsonObject o=je.getAsJsonObject();
	    	Set<Map.Entry<String, JsonElement>> set = o.entrySet();
	    	for(Map.Entry<String, JsonElement> me : set) {
	    	    try {
	    	    	System.out.print("loading object "+me.getKey()+":");
	    	    	System.out.print(me.getValue()+"->");
	    	    	JsonElement jsonElement=me.getValue();
	    	    	Class<?> c = Class.forName(me.getKey());
	    	    	Object obj=g.fromJson(jsonElement, c);
	    	    	result.add(obj);
	    	    	System.out.println(" done");
	    	    }
	    	    catch (ClassNotFoundException e) {System.out.println(e.getMessage());}
	    	    catch (SecurityException e) {System.out.println(e.getMessage());}
	    	    catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
	    	}
	    }
		return(result);
	}
	
	
	public static void invoker(ArrayList<Object> objects){
		Iterator<Object> i=objects.iterator();
		while (i.hasNext()) {
			
			Object obj=i.next();
			
	    	Method m;
			try {
				m = obj.getClass().getDeclaredMethod("out");
		    	m.invoke(obj);
			}
			catch (SecurityException e) {System.out.println(e.getMessage());}
			catch (NoSuchMethodException e) {System.out.println(e.getMessage());}
			catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
			catch (IllegalAccessException e) {System.out.println(e.getMessage());}
			catch (InvocationTargetException e) {System.out.println(e.getMessage());}
		}
	}
	
	
	public static void main(String[] args){
	    String json = "[{'json.test.Type1':{'x':1}},{'json.test.Type2':{'y':2}}]";
		String pkg="json.test";
		
		ArrayList<Object> gameObjects=fromJSON2Array(json,pkg);

		invoker(gameObjects);
		
	    System.out.println(fromArray2JSON(gameObjects,pkg));
	    
	}
}
