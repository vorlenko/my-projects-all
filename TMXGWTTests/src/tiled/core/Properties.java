package tiled.core;

import java.util.HashMap;

public class Properties extends HashMap<String,String>{
	private static final long serialVersionUID = 1L;

	public String getProperty(String key){
		return get(key);
	}
}
