package com.tmx.client;



import tiled.core.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("GameService")
public interface GameService extends RemoteService {
	  Map getGameData() throws IllegalArgumentException;


}
