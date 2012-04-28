package tiled.core;

import java.util.HashMap;

public class Properties extends HashMap<String,String>{
	private static final long serialVersionUID = 1L;

	public String getProperty(String key){
		return get(key);
	}

	public void setProperty(String key,String value){
		put(key,value);
	}
	
	public Properties(){}
}
