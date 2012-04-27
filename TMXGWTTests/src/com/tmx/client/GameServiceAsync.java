package com.tmx.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GameServiceAsync {
	  void getGameData(AsyncCallback<String> callback) throws IllegalArgumentException;

}
