package com.tmx.client;





import tiled.core.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class TMXGWTTests implements EntryPoint {
	
    static final int refreshRate = 25;
    HTMLPanel panel;
    static final String id = "gamePanel";

    Game game;
    
	private final GameServiceAsync gameService = (GameServiceAsync) GWT.create(GameService.class);

	public void onModuleLoad() {
 	
    	gameService.getGameData(new AsyncCallback<Map>() {
            public void onFailure(Throwable caught) {
            	Window.alert(caught.getMessage());
            }

            public void onSuccess(Map map) {
            
            	game = new Game(map);
         		
      	
            	
        	    panel = new HTMLPanel("<div class=\"content\" id=\"" + id + "\"></div>");
                panel.setStyleName("contentHolder");
                
                Window.addResizeHandler(new ResizeHandler() {
                	 
                    public void onResize(ResizeEvent event)
                    {
                    	resizeCanvas(panel.getOffsetWidth()-10,panel.getOffsetHeight()-10);
                    }
                });

                RootPanel.get().add(panel,0,0);
                panel.setSize("100%", "100%");

            	resizeCanvas(panel.getOffsetWidth()-10,panel.getOffsetHeight()-10);
            	
                final Timer timer = new Timer() {
                    public void run() {
                       drawSomethingNew();
                    }
                };
                timer.scheduleRepeating(refreshRate);
             
            
            }
        });
	}

	int i=0;

	public void drawSomethingNew() {
		panel.clear();
	
		i++;
		if(i%2==1){
			game.render(screen1,refreshRate);
			panel.add(screen1.getCanvas(), id);
		}else{
			game.render(screen2,refreshRate);
			panel.add(screen2.getCanvas(), id);
		}
	}

	Screen screen1;
	Screen screen2;
	
	private void resizeCanvas(int width, int height)
    {
        width = Math.max(0, width);
        height = Math.max(0,height);
 
        panel.clear();

        screen1 = new Screen();
        screen2 = new Screen();
        screen1.resize(width,height);
        screen2.resize(width,height);
        game.resize(width,height);
    }
}
