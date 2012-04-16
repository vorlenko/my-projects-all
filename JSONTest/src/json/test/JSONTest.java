package json.test;

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
		boolean first=true;
		Iterator<Object> i=objects.iterator();
		while (i.hasNext()) {
			Object obj=i.next();
			String name=obj.getClass().toString();
			name=name.replaceAll("(?:class )", "");
			String value=g.toJson(obj);
			if(!first){result+=",";}else{first=false;}
			result+="{'"+name+"':"+value+"}";
		}
		result="["+result.replaceAll("(?:')", "\"")+"]";
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
	    	    	JsonElement jsonElement=me.getValue();
	    	    	Class<?> c = Class.forName(me.getKey());
	    	    	Object obj=g.fromJson(jsonElement, c);
	    	    	result.add(obj);
	    	    }
	    	    catch (ClassNotFoundException e) {System.out.println(e.getMessage());}
	    	    catch (SecurityException e) {System.out.println(e.getMessage());}
	    	    catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
	    	}
	    }
		return(result);
	}
	
	
	public static void invoker(ArrayList<Object> objects,String methodName,Object... args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Iterator<Object> i=objects.iterator();
		while (i.hasNext()) {
			Object obj=i.next();
				
			Method[] methods = obj.getClass().getMethods();
				
			for(Method method:methods){
			
				boolean coincidence=true;
			
				//check that args types==params types
				@SuppressWarnings("rawtypes")
				Class parameterTypes[]=method.getParameterTypes();
				
				if(method.getName().equals(methodName)&&(args.length==parameterTypes.length)){


					//check types of args and params (to call method it have to be the same)
					int j=0;
					for(@SuppressWarnings("rawtypes") Class type:parameterTypes){
						if(!type.equals(args[j].getClass())){
							coincidence=false; break;
						}
						j++;
					}
					
					//check return types... not ready yet :P 
					
					if(coincidence){
						method.invoke(obj,args);
					}

				}

					
			}
			
		}
	}
	
	
	public static void main(String[] args){
	    String json = "[{'json.test.Type1':{'x':1}},{'json.test.Type2':{'y':2}}]";
		String pkg="json.test";
		
		ArrayList<Object> gameObjects=fromJSON2Array(json,pkg);

		
		//ArrayList<Object> gameObjects = new ArrayList<Object>(); 
		gameObjects.add(new Type3());
		
		
		try {
			invoker(gameObjects,"out","ba","bo");
		}
		catch (SecurityException e) {System.out.println(e.getMessage());}
		catch (NoSuchMethodException e) {System.out.println(e.getMessage());}
		catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
		catch (IllegalAccessException e) {System.out.println(e.getMessage());}
		catch (InvocationTargetException e) {System.out.println(e.getMessage());}
		
	    System.out.println(fromArray2JSON(gameObjects,pkg));
	    
	}
}
