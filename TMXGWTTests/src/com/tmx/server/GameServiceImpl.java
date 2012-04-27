package com.tmx.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tmx.client.GameService;

public class GameServiceImpl extends RemoteServiceServlet implements GameService {
	private static final long serialVersionUID = 1L;

	public String getGameData() throws IllegalArgumentException {
		
		return("hello");
	}

}
