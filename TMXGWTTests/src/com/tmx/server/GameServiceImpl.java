package com.tmx.server;


import tiled.core.Map;
import tiled.io.TMXMapReader;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tmx.client.GameService;

public class GameServiceImpl extends RemoteServiceServlet implements GameService {
	private static final long serialVersionUID = 1L;

	public String getGameData() throws IllegalArgumentException {
 		String result="fault";
 		
        try {
            TMXMapReader mapReader = new TMXMapReader();
     		Map map = mapReader.readMap("desert.tmx");
            result="ok";
        } catch (Exception e) {}

		
		return(result);
	}

}
