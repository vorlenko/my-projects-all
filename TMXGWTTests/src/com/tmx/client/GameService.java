package com.tmx.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("GameService")
public interface GameService extends RemoteService {
	  String getGameData() throws IllegalArgumentException;


}
