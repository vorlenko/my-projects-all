package com.tmx.server;


import java.util.Iterator;

import tiled.core.Map;
import tiled.core.MapLayer;
import tiled.core.MapObject;
import tiled.core.ObjectGroup;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tmx.client.GameService;

public class GameServiceImpl extends RemoteServiceServlet implements GameService {
	private static final long serialVersionUID = 1L;

	public Map getGameData() throws IllegalArgumentException {

		Map map=null;
		
        try {
            TMXMapReader mapReader = new TMXMapReader();
     		map = mapReader.readMap("desert.tmx");
     		
    

            
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }

		
		return(map);
	}

}
