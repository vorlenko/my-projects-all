package com.tmx.client;


import tiled.core.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GameServiceAsync {
	  void getGameData(AsyncCallback<Map> callback) throws IllegalArgumentException;

}
